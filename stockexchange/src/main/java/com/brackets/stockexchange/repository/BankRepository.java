package com.brackets.stockexchange.repository;

import com.brackets.stockexchange.model.Bank;
import org.springframework.data.repository.CrudRepository;

public interface BankRepository extends CrudRepository <Bank, Integer>, BankRepositoryCustom{
}


