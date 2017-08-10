package com.fp.dao;

/**
 * Created by jayme on 8/10/2017.
 */
public class DAOFactory {
    public static final int FINANCES_DAO = 0;

    public static FinancesDAO getinstance(int financesDao) {

        switch (financesDao){

            case FINANCES_DAO:
                return new FinancesDaoImpl();
                default:
                    break;
        }
        return null;
    }
}
