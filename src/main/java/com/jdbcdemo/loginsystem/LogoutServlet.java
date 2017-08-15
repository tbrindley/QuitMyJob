package com.jdbcdemo.loginsystem;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Travis Brindley on 8/15/2017.
 */
public class LogoutServlet {
    public static String logout(HttpServletResponse response, HttpServletRequest request){
        Cookie[] cookies = request.getCookies();

        Cookie userCookie = cookies[0];

        userCookie.setMaxAge(0); //clears out user cookie
        response.addCookie(userCookie);

        return "index";
    }
}
