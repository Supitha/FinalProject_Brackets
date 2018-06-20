package com.brackets.stockexchange.repository;

import com.brackets.stockexchange.model.Broker_customer;
import com.brackets.stockexchange.model.Broker_stocks;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Created by rajith on 6/18/18.
 */
@Repository
public class BrokerRepositoryImpl implements BrokerRepositoryCustom {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public void createNewCustomerForBroker(Broker_customer broker_customer) {
        Query query = entityManager.createNativeQuery("INSERT INTO broker_customer VALUES (?,?)", Broker_customer.class);
        query.setParameter(1, broker_customer.getBroker_name());
        query.setParameter(2, broker_customer.getCustomer_name());
        entityManager.persist(broker_customer);
        entityManager.flush();
    }

    @Override
    @Transactional
    public boolean checkQty(Broker_stocks broker_stocks) {
        int cqty = broker_stocks.getQuantity();
        String cname = broker_stocks.getCusName();
        String bname = broker_stocks.getBroker_name();
        Query query = entityManager.createNativeQuery("select * from broker_stocks where (stock = ? and broker_name = ?)", Broker_stocks.class);
        query.setParameter(1, broker_stocks.getStock());
        query.setParameter(2, bname);
        query.setMaxResults(1);
        if (query.getResultList().size() == 0) {
            return false;
        }
        Broker_stocks cus = (Broker_stocks) query.getSingleResult();

        int qty = cus.getQuantity();
        if (cqty <= qty) {
            updateBrokerStocks(cus, cqty);
            addTomBrokerCustomer(cus, cqty, cname);
            return true;
        } else {
            return false;
        }
    }

    @Override
    @Transactional
    public void updateBrokerStocks(Broker_stocks broker_stocks, int qty) {
        Query query = entityManager.createNativeQuery("UPDATE broker_stocks set quantity=quantity-(?) WHERE stock=(?)", Broker_stocks.class);
        query.setParameter(1, qty);
        query.setParameter(2, broker_stocks.getStock());
        query.executeUpdate();
    }

    @Override
    @Transactional
    public void addTomBrokerCustomer(Broker_stocks broker_stocks, int qty, String cname) {
        Query query = entityManager.createNativeQuery("UPDATE broker_customer set price_bought=(?),quantity=(?),stocks=(?) WHERE customer_name=(?)", Broker_stocks.class);
        query.setParameter(1, broker_stocks.getPrice());
        query.setParameter(2, qty);
        query.setParameter(3, broker_stocks.getStock());
        query.setParameter(4, cname);
        query.executeUpdate();
    }

    @Override
    @Transactional
    public boolean sellStocks(Broker_customer broker_customer) {
        Query query = entityManager.createNativeQuery("UPDATE  broker_customer set price_sell=(?) WHERE customer_name=(?) AND broker_name=(?)  AND stocks=(?)", Broker_customer.class);
        query.setParameter(1, broker_customer.getPrice_sell());
        query.setParameter(2, broker_customer.getCustomer_name());
        query.setParameter(3, broker_customer.getBroker_name());
        query.setParameter(4,broker_customer.getStocks());

        if (query.executeUpdate() == 1) {
            return true;
        }else {
            return false;
        }
    }
}
