package com.fp.dao;

import com.fp.models.Finances;

/**
 * Created by jayme on 8/10/2017.
 */
public interface FinancesDAO {
    Finances getFinancesInfoByClientId(int client_id);
}
