package com.jdbcdemo.controller;

/**
 * Created by Travis Brindley on 7/21/2017.
 */
import com.fp.models.Clients;
import com.jdbcdemo.BoLS;
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
    public String homePage(){
        return "index";
    }

    @RequestMapping("/register")
    public String addClients() {
        return "register";
    }

    @RequestMapping("/addfinancials")
    public String addFinancials(Model model) {
        
        int[]arrayList = BoLS.getBoLS();

        //populates financial form with Midwest averages
        model.addAttribute("rent",arrayList[0]);
        model.addAttribute("utilities",arrayList[1]);
        model.addAttribute("autoGas",arrayList[2]);
        model.addAttribute("carInsurance",arrayList[3]);
        model.addAttribute("carPayment",arrayList[4]);
        model.addAttribute("groceries",arrayList[5]);
        model.addAttribute("restaurant",arrayList[6]);
        model.addAttribute("studentLoans",arrayList[7]);
        model.addAttribute("medInsurance",arrayList[8]);
        model.addAttribute("miscExpenses",arrayList[9]);
        model.addAttribute("creditCard",arrayList[10]);
        model.addAttribute("otherMisc",arrayList[11]);
            return "createfinancials";
        }

        @RequestMapping("/userhome")
        public String userHome (@RequestParam("th_savings") int savings,
                                @RequestParam("th_income") int income,
                                @RequestParam("rent") int rent,
                                @RequestParam("utils") int utils,@RequestParam("gas") int gas, @RequestParam("c_insurance")
                                               int c_ins,@RequestParam("c_bill") int c_bill,@RequestParam("groceries")
                                                int groceries,@RequestParam("restaurant") int rest,@RequestParam("creditCard") int cCard,
                                @RequestParam("s_loans") int s_loans,@RequestParam("o_debt") int o_debt,@RequestParam("o_expense")
                                               int o_exp,@RequestParam("meds") int meds, Model model) {

                model.addAttribute("th_savings",savings);
                model.addAttribute("th_income", income);
                model.addAttribute("rent", rent);
                model.addAttribute("utils",utils);
                model.addAttribute("gas",gas);
                model.addAttribute("c_insurance", c_ins);
                model.addAttribute("c_bill",c_bill);
                model.addAttribute("groceries",groceries);
                model.addAttribute("restaurant",rest);
                model.addAttribute("creditCard",cCard);
                model.addAttribute("s_loans",s_loans);
                model.addAttribute("o_debt",o_debt);
                model.addAttribute("o_expense", o_exp);
                model.addAttribute("meds", meds);

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

