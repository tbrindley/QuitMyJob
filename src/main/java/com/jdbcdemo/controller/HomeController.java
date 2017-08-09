package com.jdbcdemo.controller;

/**
 * Created by Travis Brindley on 7/21/2017.
 */
import com.fp.models.Clients;
import org.apache.http.HttpHost;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.hibernate.*;

import java.sql.*;
import java.util.ArrayList;

@Controller
public class HomeController {

    @RequestMapping("/")

    public ModelAndView helloWorld() {

        return new
                ModelAndView("index", "message", "Welcome to Quit My Job Web App");

    }

    @RequestMapping("/register")
    public String addClients() {


        return "register";
    }

    @RequestMapping("/addfinancials")
    public String addFinancials(@RequestParam("user_id") String userName,
                                @RequestParam("email") String Email,
                                @RequestParam("psw") String pswd,
                                @RequestParam("curjob") String career, Model model) throws ClassNotFoundException, SQLException {

        Configuration cfg = new Configuration().configure("hibernate.cfg.xml");

        SessionFactory sessionFact = cfg.buildSessionFactory();

        Session session = sessionFact.openSession();
        Transaction tx = session.beginTransaction();

        Clients newClient = new Clients();

        newClient.setEmail(Email);
        newClient.setPassword(pswd);
        newClient.setUserId(userName);
        newClient.setJob(career);

        session.save(newClient);
        tx.commit();
        session.close();

        model.addAttribute("newStuff", newClient);
        //step 6 process results
        ArrayList<String> list = new ArrayList<String>();


        model.addAttribute("dbResult", list);

            return "createfinancials";
        }

        @RequestMapping("/userhome")
        public String userHome () {

            return "countdown";
        }

        @RequestMapping("/updateuser")
        public String updateUser () {

            return "update";
        }

        @RequestMapping("/breakdown")
        public String userBreakdown () {

            return "breakdown";
        }

        @RequestMapping("/jobsearch")
        public String jobSearch () {

            //the HTTPClient Interface represents the contract for the HTTP Request execution
            HttpClient http = HttpClientBuilder.create().build();

            HttpHost host = new HttpHost("forecast.weather.gov", 80, "http");

            // HttpGet retrieves the info identified by the request URI (in the form of an entity)
            HttpGet getPage = new HttpGet("/MapClick.php?lat=42.331427&lon=-83.045754&FcstType=json");


            return "jobsearch";
        }
    }

