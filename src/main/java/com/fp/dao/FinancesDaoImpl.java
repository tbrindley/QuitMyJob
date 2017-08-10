package com.fp.dao;

import com.fp.models.Finances;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by jayme on 8/10/2017.
 */
public class FinancesDaoImpl implements FinancesDAO {
    public Finances getFinancesInfoByClientId(int client_id) {

        Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
        SessionFactory sessionFact = cfg.buildSessionFactory();
        Session session = sessionFact.openSession();
        Transaction tx = session.beginTransaction();

        Criteria crit = session.createCriteria(Finances.class);
        crit.add(Restrictions.eq("clientid", client_id));
        ArrayList<Finances> list = (ArrayList<Finances>) crit.list();


        tx.commit();
        session.close();
        return list.get(0);
    }
}
