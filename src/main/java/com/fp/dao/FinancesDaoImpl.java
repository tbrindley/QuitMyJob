package com.fp.dao;

import com.fp.models.Finances;
import com.quitmyjob.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;

/**
 * Created by jayme on 8/10/2017.
 */
public class FinancesDaoImpl implements FinancesDAO {
    private static SessionFactory sessionFactory;

    public FinancesDaoImpl() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    public Finances getFinancesInfoByClientId(int client_id) {

        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        Criteria crit = session.createCriteria(Finances.class);
        crit.add(Restrictions.eq("clientid", client_id));
        ArrayList<Finances> list = (ArrayList<Finances>) crit.list();


        tx.commit();
        return list.get(0);
    }
}
