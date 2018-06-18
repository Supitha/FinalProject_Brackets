package com.brackets.stockexchange.repository;

import com.brackets.stockexchange.model.Stocks;
import org.springframework.data.repository.CrudRepository;

public interface StocksRepository  extends CrudRepository <Stocks, Integer> {
}
