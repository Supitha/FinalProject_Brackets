package com.brackets.stockexchange.repository;

import com.brackets.stockexchange.model.Bank;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class BankRepositoryImpl implements BankRepositoryCustom{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Bank> getAccByname(String account_name) {
        Query query = entityManager.createNativeQuery("SELECT * from bank " +
                "WHERE account_name LIKE ?", Bank.class);
        query.setParameter(1, account_name + "%");
        return query.getResultList();
    }

    @Override
    @Transactional
    public void createNewAccountForUser(Bank bank) {
        Query query = entityManager.createNativeQuery("INSERT INTO bank values(?,?)", Bank.class);
        query.setParameter(1, bank.getAccount_name());
        query.setParameter(2, bank.getBalance());
        entityManager.persist(bank);
        entityManager.flush();
    }
}
