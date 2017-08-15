package com.jdbcdemo.loginsystem;

import com.fp.models.Clients;
import com.jdbcdemo.util.HibernateUtil;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

/**
 * Created by Travis Brindley on 8/15/2017.
 */
public class LoginServlet {
    public static int getClient(String username, String password, HttpServletResponse response) {
        int client_id=0;

        Session session = HibernateUtil.getSessionFactory().openSession(); //creates session to database
        Transaction tx = session.beginTransaction();

        Criteria crit = session.createCriteria(Clients.class);
        //crit.add(Restrictions.like("user_id",username));
        ArrayList<Clients> list = (ArrayList<Clients>) crit.list();
        for (int i = 0; i < list.size(); i++) {
            Clients tempClient = list.get(i);
            if (username.equalsIgnoreCase(tempClient.getUserId())) {
                if (password.equals(tempClient.getPassword())) {

                    client_id = tempClient.getClientId();
                    Cookie userCookie = new Cookie("userId", Integer.toString(client_id));
                    userCookie.setMaxAge(24*60*60); //sets the cookie for 1 day
                    response.addCookie(userCookie);
                    //user authenticated now pull data from DB
                }
            }
        }
        return client_id;
    }
}
