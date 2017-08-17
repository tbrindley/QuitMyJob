package com.fp.dao;

import com.fp.models.Clients;
import com.quitmyjob.loginsystem.GetCookie;
import com.quitmyjob.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

/**
 * Created by Travis Brindley on 8/17/2017.
 */
public class GetClient {

    public static Clients getclient(HttpServletRequest request){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        Criteria crit = session.createCriteria(Clients.class);

        int client_id = GetCookie.getCookie(request);
        crit.add(Restrictions.eq("clientId", client_id));
        ArrayList<Clients> list = (ArrayList<Clients>) crit.list();
        Clients currentClient = list.get(0);
        return currentClient;
    }
}
