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
    public boolean checkQty(Broker_stocks broker_stocks) {
        int cqty = broker_stocks.getQuantity();
        Query query = entityManager.createNativeQuery("select * from broker_stocks where stock = ?", Broker_stocks.class);
        query.setParameter(1, broker_stocks.getStock());
        query.setMaxResults(1);
        Broker_stocks cus = (Broker_stocks) query.getSingleResult();
        int qty = cus.getQuantity();
        if(cqty<=qty){
            return true;
        }else{
            return false;
        }
    }
}
