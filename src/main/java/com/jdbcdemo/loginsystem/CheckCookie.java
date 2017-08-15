package com.jdbcdemo.loginsystem;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by Travis Brindley on 8/15/2017.
 */
public class CheckCookie {
    public static boolean checkCookie(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();

        if(cookies == null){
            return false;
        }
        else
            return true;

    }
}
