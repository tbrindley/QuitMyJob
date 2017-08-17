package com.quitmyjob.loginsystem;

import com.fp.models.Clients;
import com.quitmyjob.util.HibernateUtil;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

/**
 * Created by Travis Brindley on 8/15/2017.
 */
public class LoginServlet {

    public static boolean login(String username, String password, HttpServletResponse response) throws NoSuchProviderException, NoSuchAlgorithmException {
        boolean loggedIn = true;


        Session session = HibernateUtil.getSessionFactory().openSession(); //creates session to database
        Transaction tx = session.beginTransaction();

        Criteria crit = session.createCriteria(Clients.class);
        crit.add(Restrictions.eq("userId",username));

        //ArrayList<Clients> list = (ArrayList<Clients>) crit.list();
        Clients tempClient = (Clients) crit.uniqueResult();
        if(tempClient == null){
            loggedIn = false;
        }
        else{
            String securePassword = Password.MD5(password);
            if (securePassword.equals(tempClient.getPassword())) {
                int client_id = tempClient.getClientId();
                Cookie userCookie = new Cookie("userId", Integer.toString(client_id));
                userCookie.setMaxAge(24 * 60 * 60); //sets the cookie for 1 day
                response.addCookie(userCookie);
                //user authenticated now pull data from DB
                loggedIn = true;
            }
            else {
                loggedIn = false;
            }
        }
        return loggedIn;
    }
}
