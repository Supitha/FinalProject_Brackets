package com.brackets.stockexchange.repository;

import com.brackets.stockexchange.model.Broker;
import com.brackets.stockexchange.model.Broker_customer;
import com.brackets.stockexchange.model.Broker_stocks;
import com.brackets.stockexchange.model.Stocks;

import java.util.List;

/**
 * Created by rajith on 6/18/18.
 */
public interface BrokerRepositoryCustom {
    void createNewCustomerForBroker(Broker_customer broker_customer);
    String checkQty(Broker_stocks broker_stocks);
    void updateBrokerStocks(Broker_stocks broker_stocks,int qty);
    void addTomBrokerCustomer(Broker_stocks broker_stocks,int qty,String cname);
    void addToBrokerCustomer(Broker_customer broker_customer, int qty, String cname);
    boolean sellStocks(Broker_customer broker_customer);
    boolean checkUserStock(String b_name, String cusName, String stock);
    void updateSameStocksForAUser(Broker_customer broker_customer);
    List<Broker> getcustomerinfo(Broker_customer b_name);
    Stocks getPriceOfStock(String stname);
    boolean checkQtyFromCustomer(Broker_customer broker_customer);
}
