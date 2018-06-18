package com.brackets.stockexchange.repository;

import com.brackets.stockexchange.model.Stocks;

/**
 *
 * @author supithaweerasinghe
 */
public interface StocksRepositoryCustom {
    void updateStocksPrices(Stocks stocks);
}
