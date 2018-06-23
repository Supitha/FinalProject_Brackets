/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brackets.stockexchange.repository;

import com.brackets.stockexchange.model.Broker_customer;
import com.brackets.stockexchange.model.Broker_stocks;
import com.brackets.stockexchange.model.Stocks;

/**
 *
 * @author supithaweerasinghe
 */
public interface AIRepositoryCustom {
    Stocks selectCompany(Stocks st);
    String createBankAccountAI();
    Broker_stocks selectCompanyAI();
    void buyStocksAI();
    Broker_stocks selectBroker(Stocks st);
    void sellStockAI();
    Broker_customer selectStocksToSell(String stname);
}
