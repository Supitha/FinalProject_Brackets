package com.brackets.stockexchange.repository;

import com.brackets.stockexchange.model.Stocks;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author supithaweerasinghe
 */
@Repository
public class StocksRepositoryImpl implements StocksRepositoryCustom {

    @PersistenceContext
    EntityManager entityManager;
    
    @Override
    @Transactional
    public void updateStocksPrices(Stocks stocks) {
        Query query = entityManager.createNativeQuery("UPDATE stocks set price=price+(?) WHERE id=(?)", Stocks.class);
        query.setParameter(1, stocks.getPrice());
        query.setParameter(2, stocks.getId());
        query.executeUpdate();
    }
}
