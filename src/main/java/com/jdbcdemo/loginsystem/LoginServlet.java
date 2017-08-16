package com.jdbcdemo.loginsystem;

import com.fp.models.Clients;
import com.jdbcdemo.util.HibernateUtil;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.ArrayList;

/**
 * Created by Travis Brindley on 8/15/2017.
 */
public class LoginServlet {

    public static String login(String username, String password, HttpServletResponse response) throws NoSuchProviderException, NoSuchAlgorithmException {
        String directPage = "index";


        Session session = HibernateUtil.getSessionFactory().openSession(); //creates session to database
        Transaction tx = session.beginTransaction();

        Criteria crit = session.createCriteria(Clients.class);
        crit.add(Restrictions.eq("userId",username));

        //ArrayList<Clients> list = (ArrayList<Clients>) crit.list();
        Clients tempClient = (Clients) crit.uniqueResult();
        if(tempClient == null){
            directPage = "index";
        }
        else{
            String securePassword = Password.MD5(password);
            if (securePassword.equals(tempClient.getPassword())) {
                int client_id = tempClient.getClientId();
                Cookie userCookie = new Cookie("userId", Integer.toString(client_id));
                userCookie.setMaxAge(24 * 60 * 60); //sets the cookie for 1 day
                response.addCookie(userCookie);
                //user authenticated now pull data from DB
                directPage = "countdown";
            }
            else {
                directPage = "index";
            }
        }
        return directPage;
    }
}
