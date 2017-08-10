package com.jdbcdemo;

import com.fp.models.Finances;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Created by Travis Brindley on 8/10/2017.
 */
public class TimeLeft {

    public static Finances newFinances(){
        Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
        SessionFactory sessionFact = cfg.buildSessionFactory();
        Session session = sessionFact.openSession();
        Transaction tx = session.beginTransaction();

        //value of savings from database
        Finances newFinances = new Finances();
        return newFinances;
    }

    public static int getAssets(){

        int savings = newFinances().getSavings();
        return savings;
    }
    public static int getLiabilities(){

        //housing, trans, extras, food, debt,

        int liabilities = newFinances().getHousing() + newFinances().getTransporation() + newFinances().getExtras() + newFinances().getFood() + newFinances().getDebt();
        return liabilities;
    }
    public static int monthlyIncome(){
        //value of monthly income from database
        int income = newFinances().getIncome();
        return income;
    }

    public static int[] getTimeLeft() {
        {
            int asset = getAssets();
            int liability = getLiabilities();

            int[] daysleft = new int[4];
            //set months
            int month = 0;
            while (asset >= liability) {
                month++;
                asset -= liability;
                asset += monthlyIncome();
            }
            int days = 0;

            liability = liability / 30;
            while (asset >= liability) {
                days++;
                asset -= liability;
                asset += (monthlyIncome() / 30);
            }
            int hours = 0;
            liability = liability / 24;
            while (asset >= liability) {
                hours++;
                asset -= liability;
            }
            int min = 0;
            liability = liability / 60;

            while (asset > liability) {
                min++;
                asset -= liability;
            }

            daysleft[0] = month;
            daysleft[1] = days;
            daysleft[2] = hours;
            daysleft[3] = min;
            System.out.println("Months: " + month);
            System.out.println("Days: " + days);
            System.out.println("Hours: " + hours);
            System.out.println("Minutes: " + min);

            return daysleft;
        }
    }
}
