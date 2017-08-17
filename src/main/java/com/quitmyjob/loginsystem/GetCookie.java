package com.quitmyjob.loginsystem;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by Travis Brindley on 8/16/2017.
 */
public class GetCookie {
    public static int getCookie(HttpServletRequest request){
        //calls the cookie for the user & gets their client_Id
        Cookie[] cookies = request.getCookies();
        String client = cookies[0].getValue();
        int client_id = Integer.parseInt(client);

        return client_id;
    }
}
