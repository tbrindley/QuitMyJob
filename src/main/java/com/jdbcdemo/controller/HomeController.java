package com.jdbcdemo.controller;

/**
 * Created by Travis Brindley on 7/21/2017.
 */
import org.apache.http.HttpHost;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @RequestMapping("/")

    public ModelAndView helloWorld()
    {

        return new
                ModelAndView("index","message","Welcome to Quit My Job Web App");

    }

    @RequestMapping("/register")
    public String goToRegister(){
        return "register";
    }

    @RequestMapping("/addfinancials")
    public String addFinancials(){
        return "createfinancials";
    }

    @RequestMapping("/userhome")
    public String userHome(){

        return "countdown";
    }

    @RequestMapping("/updateuser")
    public String updateUser(){

        return "update";
    }

    @RequestMapping("/breakdown")
    public String userBreakdown(){

        return "breakdown";
    }

    @RequestMapping("/jobsearch")
    public String jobSearch(){

        //the HTTPClient Interface represents the contract for the HTTP Request execution
        HttpClient http = HttpClientBuilder.create().build();

        HttpHost host = new HttpHost("forecast.weather.gov", 80, "http");

        // HttpGet retrieves the info identified by the request URI (in the form of an entity)
        HttpGet getPage = new HttpGet("/MapClick.php?lat=42.331427&lon=-83.045754&FcstType=json");


        return "jobsearch";
    }
}
