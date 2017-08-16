package com.jdbcdemo.controller;

/**
 * Created by Travis Brindley on 7/21/2017.
 */

import com.fp.models.Clients;
import com.fp.models.Finances;
import com.jdbcdemo.BoLS;
import com.jdbcdemo.TimeLeft;
import com.jdbcdemo.loginsystem.CheckCookie;
import com.jdbcdemo.loginsystem.LoginServlet;
import com.jdbcdemo.util.HibernateUtil;
import org.apache.http.HttpHost;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.RequestAddCookies;
import org.apache.http.impl.client.HttpClientBuilder;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.sql.SQLException;

import java.math.BigDecimal;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.sql.*;
import java.util.ArrayList;

@Controller
public class HomeController {


    @RequestMapping("/")
    public String homePage() {
        return "index";
    }

    @RequestMapping("/register")
    public String addClients() {
        return "register";
    }

    @RequestMapping("/addUserFinancials")
    //adds registration info. to DB
    public String addUserFinancials(@RequestParam("user_id") String userName,

                               @RequestParam("email") String Email,
                                            @RequestParam("psw") String pswd,
                                            @RequestParam("curjob") String career, Model model) throws ClassNotFoundException, SQLException, NoSuchProviderException, NoSuchAlgorithmException {



        /*Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
        SessionFactory sessionFact = cfg.buildSessionFactory();*/
        Session session = HibernateUtil.getSessionFactory().openSession(); // sessionFact.openSession();
        System.out.println(session);
        Transaction tx = session.beginTransaction();

        Clients newClient = new Clients();
        newClient.setEmail(Email);
        newClient.setPassword(Password.MD5(pswd));
        newClient.setUserId(userName);
        newClient.setJob(career);

        Integer clientId = (Integer) session.save(newClient);

        tx.commit();
//        session.close();

        model.addAttribute("newStuff", newClient);
        model.addAttribute("clientid", clientId);

        ArrayList<String> list = new ArrayList<String>();
        model.addAttribute("dbResult", list);


        int[] arrayList = BoLS.getBoLS();

        //populates financial form with Midwest averages
        model.addAttribute("rent", arrayList[0]);
        model.addAttribute("utilities", arrayList[1]);
        model.addAttribute("autoGas", arrayList[2]);
        model.addAttribute("carInsurance", arrayList[3]);
        model.addAttribute("carPayment", arrayList[4]);
        model.addAttribute("groceries", arrayList[5]);
        model.addAttribute("restaurant", arrayList[6]);
        model.addAttribute("studentLoans", arrayList[7]);
        model.addAttribute("medInsurance", arrayList[8]);
        model.addAttribute("miscExpenses", arrayList[9]);
        model.addAttribute("creditCard", arrayList[10]);
        model.addAttribute("otherMisc", arrayList[11]);
        return "createfinancials";
    }

    @RequestMapping("/login")
    public String login(Model model, @RequestParam("userName") String username, @RequestParam("password") String password, HttpServletResponse response, HttpServletRequest request) throws NoSuchProviderException, NoSuchAlgorithmException {

        String reDirect = LoginServlet.login(username, password, response);

        //calls the cookie for the user & gets their client_Id
        Cookie[] cookies = request.getCookies();
        String client = cookies[0].getValue();
        System.out.println(client);

        int client_id = Integer.parseInt(client);



        int[] arrayList = TimeLeft.getTimeLeft(client_id);

        //populates financial form with Midwest averages
        model.addAttribute("months", arrayList[0]);
        model.addAttribute("days", arrayList[1]);
        model.addAttribute("hours", arrayList[2]);
        model.addAttribute("min", arrayList[3]);

        return reDirect;

    }


    @RequestMapping("/addGuestFinancials")
    public String addGuestFinancials(Model model) {

        int[] arrayList = BoLS.getBoLS();

        //populates financial form with Midwest averages
        model.addAttribute("rent", arrayList[0]);
        model.addAttribute("utilities", arrayList[1]);
        model.addAttribute("autoGas", arrayList[2]);
        model.addAttribute("carInsurance", arrayList[3]);
        model.addAttribute("carPayment", arrayList[4]);
        model.addAttribute("groceries", arrayList[5]);
        model.addAttribute("restaurant", arrayList[6]);
        model.addAttribute("studentLoans", arrayList[7]);
        model.addAttribute("medInsurance", arrayList[8]);
        model.addAttribute("miscExpenses", arrayList[9]);
        model.addAttribute("creditCard", arrayList[10]);
        model.addAttribute("otherMisc", arrayList[11]);
        return "createfinancials";
    }

    @RequestMapping("/userhome")
    public String userHome(Model model, @RequestParam("th_savings") int savings,
                           @RequestParam("th_income") int income,
                           @RequestParam("rent") int rent, @RequestParam("utils") int utils,
                           @RequestParam("gas") int gas, @RequestParam("c_insurance") int c_ins,
                           @RequestParam("c_bill") int c_bill, @RequestParam("groceries") int groceries,
                           @RequestParam("restaurant") int rest, @RequestParam("creditCard") int cCard,
                           @RequestParam("s_loans") int s_loans, @RequestParam("o_debt") int o_debt,
                           @RequestParam("o_expense") int o_exp, @RequestParam("meds") int meds,
                           @RequestParam("clientId") int client_id) {


//    Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
//    SessionFactory sessionFact = cfg.buildSessionFactory();
//    Session session = sessionFact.openSession();
        Session session = HibernateUtil.getSessionFactory().openSession();
        System.out.println(session);
        Transaction tx = session.beginTransaction();


        //This will add up the information from each section and send the totals to the DB.

        int housing = rent + utils + gas;
        int trans = c_ins + c_bill;
        int extras = o_exp + meds;
        int food = groceries + rest;
        int debt = cCard + s_loans + o_debt;

        Finances newFinances = new Finances();
        newFinances.setSavings(savings);
        newFinances.setIncome(income);
        newFinances.setHousing(housing);
        newFinances.setTransporation(trans);
        newFinances.setExtras(extras);
        newFinances.setFood(food);
        newFinances.setDebt(debt);
        newFinances.setClientid(client_id);
        session.save(newFinances);
        tx.commit();
        //session.close();


        int[] arrayList = TimeLeft.getTimeLeft(client_id);

        //populates financial form with Midwest averages
        model.addAttribute("months", arrayList[0]);
        model.addAttribute("days", arrayList[1]);
        model.addAttribute("hours", arrayList[2]);
        model.addAttribute("min", arrayList[3]);

        return "countdown";
    }

    @RequestMapping("/updateuser")
    public String updateUser(HttpServletRequest request) {
        boolean loggedin = CheckCookie.checkCookie(request);
        if (loggedin) {
            Cookie[] cookies = request.getCookies();


            String client = cookies[0].getValue();
            System.out.println(client);
            int client_id = Integer.parseInt(client);

                return "update";
            }
            else{
                return "index";
            }
        }

    @RequestMapping("/breakdown")
    public String userBreakdown() {

        return "breakdown";
    }

    @RequestMapping("/jobsearch")
    public ModelAndView getIndeed(Model model) {
        String jsonString = callURL("http://api.indeed.com/ads/apisearch?publisher=2945076701195809&q=java&l=detroit&format=json&sort=&radius=&st=&jt=&start=&limit=50&fromage=&filter=&latlong=1&co=us&chnl=&userip=1.2.3.4&useragent=Mozilla/%2F4.0%28Firefox%29&v=2");
        System.out.println("\n\njsonString: " + jsonString);

// Replace this try catch block for all below subsequent examples
        try {
            JSONObject jsonObject = new JSONObject(jsonString);
            JSONArray jsonArray = jsonObject.getJSONArray("results");
            int count = jsonArray.length(); // get totalCount of all jsonObjects
            for (int i = 0; i < count; i++) {   // iterate through jsonArray
                JSONObject jsonPosts = jsonArray.getJSONObject(i);  // get jsonObject @ i position
                System.out.println("jsonObject " + i + ": " + jsonPosts.get("jobtitle"));
                System.out.println(("jsonObject " + i + ": " + jsonPosts.get("company")));
                System.out.println();
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        //String to hold data for our loop once we return the json array
        String text = "";
        String text2 = "";
        JSONObject jsonObject = new JSONObject(jsonString);
        JSONArray jsonArray = jsonObject.getJSONArray("results");
        jsonArray.toString();

        //create a json array to hold the data in the "text" array node
        //also
        JSONArray ar = jsonObject.getJSONArray("results");


        //loop through json array
        for (int i = 0; i < ar.length(); i++) {
            text += ("<h6>" + ar.getJSONObject(i).getString("jobtitle") + "</h6>" + "<h6>" + ar.getJSONObject(i).getString("company") + "</h6>" + "<h6>" + ar.getJSONObject(i).getString("url") + "</h6>");

        }
        model.addAttribute("jSonArray", text);
        return new ModelAndView("indeedJson", "message", jsonArray);
    }

    public static String callURL(String myURL) {
        System.out.println("Requested URL:" + myURL);
        StringBuilder sb = new StringBuilder();
        URLConnection urlConn = null;
        InputStreamReader in = null;
        try {
            URL url = new URL(myURL);
            urlConn = url.openConnection();
            if (urlConn != null)
                urlConn.setReadTimeout(60 * 1000);
            if (urlConn != null && urlConn.getInputStream() != null) {
                in = new InputStreamReader(urlConn.getInputStream(),
                        Charset.defaultCharset());
                BufferedReader bufferedReader = new BufferedReader(in);
                if (bufferedReader != null) {
                    int cp;
                    while ((cp = bufferedReader.read()) != -1) {
                        sb.append((char) cp);
                    }
                    bufferedReader.close();
                }
            }
            in.close();
        } catch (Exception e) {
            throw new RuntimeException("Exception while calling URL:" + myURL, e);
        }

        return sb.toString();
    }


    @RequestMapping("/quit")
    public String quitMyJob(HttpServletRequest request) {
        boolean loggedin = CheckCookie.checkCookie(request);
        if (loggedin) {
            Cookie[] cookies = request.getCookies();

            String client = cookies[0].getValue();
            System.out.println(client);
            int client_id = Integer.parseInt(client);

            return "quitmyjob";
        } else {
            return "index";
        }
    }

    @RequestMapping("/quitmyjob")
    public String iQuit(Model model, @RequestParam("companyName") String companyName, @RequestParam("companyAddress") String companyAddress,
                        @RequestParam("companyZip") String companyZip, @RequestParam("companyState") String state, @RequestParam("boss") String boss,
                        @RequestParam("userFullName") String fullName, @RequestParam("position") String position, @RequestParam("lastDay") String lastDay,
                        @RequestParam("city") String city) {
        model.addAttribute("company", companyName);
        model.addAttribute("address", companyAddress);
        model.addAttribute("city", city);
        model.addAttribute("state", state);
        model.addAttribute("zip", companyZip);
        model.addAttribute("boss", boss);
        model.addAttribute("position", position);
        model.addAttribute("lastDay", lastDay);
        model.addAttribute("fullName", fullName);
        return "letter";
    }


    @RequestMapping("/countdownclock")
    public String goToCountdown(HttpServletRequest request, Model model) {
        boolean loggedin = CheckCookie.checkCookie(request);
        if (loggedin) {
            Cookie[] cookies = request.getCookies();

            String client = cookies[0].getValue();
            System.out.println(client);
            int client_id = Integer.parseInt(client);

            int[] arrayList = TimeLeft.getTimeLeft(client_id);

            //populates financial form with Midwest averages
            model.addAttribute("months", arrayList[0]);
            model.addAttribute("days", arrayList[1]);
            model.addAttribute("hours", arrayList[2]);
            model.addAttribute("min", arrayList[3]);

            return "countdown";
        } else {
            return "index";
        }

    }

    @RequestMapping("/logout")
    public String logout() {
        String page = logout();
        return page;
    }
}
