package com.brackets.stockexchange.repository;

import com.brackets.stockexchange.model.Bank;

import java.util.List;

public interface BankRepositoryCustom {

    void createNewAccountForUser(Bank bank);

    List<Bank> getAccByname(String account_name);

    Bank balance(String username);

    void deduct(String accName, int amount);
 }
