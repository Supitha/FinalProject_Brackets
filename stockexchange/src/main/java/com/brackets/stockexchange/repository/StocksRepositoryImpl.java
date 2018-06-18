package com.brackets.stockexchange.repository;

//import com.brackets.stockexchange.model.Stocks;
//import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
//import javax.persistence.Query;

/**
 *
 * @author supithaweerasinghe
 */
public class StocksRepositoryImpl {

    @PersistenceContext
    EntityManager entityManager;
    
//    @Override
//    public void createNewAccountForUser(Stocks stocks){
//        Query query = entityManager.createNativeQuery("INSERT INTO stocks values(?,?,?,?,?)", Stocks.class);
//        query.setParameter(1, stocks.getId());
//        query.setParameter(2, stocks.getPrice());
//        query.setParameter(3, stocks.getQty());
//        query.setParameter(4, stocks.getSector());
//        query.setParameter(5, stocks.getStockName());
//        entityManager.persist(stocks);
//        entityManager.flush();
//    }
}
