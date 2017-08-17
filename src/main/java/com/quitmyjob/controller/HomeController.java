package com.quitmyjob.controller;

/**
 * Created by Travis Brindley on 7/21/2017.
 */

import com.fp.dao.GetClient;
import com.fp.models.Clients;
import com.fp.models.Finances;
import com.quitmyjob.API.BoLS;
import com.quitmyjob.API.Indeed;
import com.quitmyjob.TimeLeft;
import com.quitmyjob.loginsystem.*;
import com.quitmyjob.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

@Controller
public class HomeController {

    //Homepage
    @RequestMapping("/")
    public String homePage() {
        return "index";
    }


    // -------------- Setup Account Links -------------------
    //user registration
    @RequestMapping("/register")
    public String addClients() {
        return "register";
    }
    //financial registration
    @RequestMapping("/addUserFinancials")
    //adds registration info. to DB
    public String addUserFinancials(@RequestParam("user_id") String userName, @RequestParam("email") String Email,
                                    @RequestParam("psw") String pswd,
                                    @RequestParam("curjob") String career, Model model) throws ClassNotFoundException, SQLException, NoSuchProviderException, NoSuchAlgorithmException {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Clients newClient = new Clients();
        newClient.setEmail(Email);
        newClient.setPassword(Password.MD5(pswd));
        newClient.setUserId(userName);
        newClient.setJob(career);

        Integer clientId = (Integer) session.save(newClient);

        tx.commit();

        model.addAttribute("clientid", clientId);

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
                           @RequestParam("clientId") int client_id, HttpServletRequest request,
                           HttpServletResponse response) {

        Session session = HibernateUtil.getSessionFactory().openSession();
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

        Cookie userCookie = new Cookie("userId", Integer.toString(client_id));
        userCookie.setMaxAge(24 * 60 * 60); //sets the cookie for 1 day
        response.addCookie(userCookie);

/*
        String clientName = GetClient.getclient(request).getUserId();
        int[] arrayList = TimeLeft.getTimeLeft(client_id);

        //populates financial form with Midwest averages
        model.addAttribute("months", arrayList[0]);
        model.addAttribute("days", arrayList[1]);
        model.addAttribute("hours", arrayList[2]);
        model.addAttribute("min", arrayList[3]);
        model.addAttribute("clientName", clientName);
*/
        model.addAttribute("userCreated","User created.  Please login");
        return "index";
    }

    //------------ End of Account setup Links -----------------
    @RequestMapping("/login")
    public String login(Model model, @RequestParam("userName") String username, @RequestParam("password") String password, HttpServletResponse response, HttpServletRequest request) throws NoSuchProviderException, NoSuchAlgorithmException {

        //verifies user is logged
        boolean reDirect = LoginServlet.login(username, password, response);

        if(reDirect) {
            int client_id = GetCookie.getCookie(request);
            String clientName = GetClient.getclient(request).getUserId();
            int[] arrayList = TimeLeft.getTimeLeft(client_id);

            //populates financial form with Midwest averages
            model.addAttribute("months", arrayList[0]);
            model.addAttribute("days", arrayList[1]);
            model.addAttribute("hours", arrayList[2]);
            model.addAttribute("min", arrayList[3]);
            model.addAttribute("clientName",clientName);

            return "countdown";
        }
        else {
            model.addAttribute("alert","Invalid username & password");
            return "index";
        }
    }

    @RequestMapping("/jobsearch")
    public String getJobs(Model model, HttpServletRequest request) {
        String text = Indeed.getIndeed(request);
        model.addAttribute("jSonArray", text);
        String clientName = GetClient.getclient(request).getUserId();
        model.addAttribute("clientName", clientName);
        return "jobsearch";
    }

    @RequestMapping("/quit")
    public String quitMyJob(HttpServletRequest request, Model model) {
        boolean loggedin = CheckCookie.checkCookie(request);
        if (loggedin) {
            Cookie[] cookies = request.getCookies();

            String client = cookies[0].getValue();
            System.out.println(client);
            String clientName = GetClient.getclient(request).getUserId();
            model.addAttribute("clientName", clientName);

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
            int client_id = GetCookie.getCookie(request);
            String clientName = GetClient.getclient(request).getUserId();
            model.addAttribute("clientName", clientName);

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
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        String page = LogoutServlet.logout(response, request);
        return page;
    }
}
