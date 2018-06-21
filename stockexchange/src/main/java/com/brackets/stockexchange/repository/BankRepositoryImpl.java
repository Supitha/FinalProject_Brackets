package com.brackets.stockexchange.repository;

import com.brackets.stockexchange.model.Bank;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class BankRepositoryImpl implements BankRepositoryCustom {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Bank> getAccByname(String account_name) {
        Query query = entityManager.createNativeQuery("SELECT * from bank " +
                "WHERE account_name LIKE ?", Bank.class);
        query.setParameter(1, account_name + "%");
        return query.getResultList();
    }

//    @Override
//    public List<Bank> balance(String account_name) {
//        Query query = entityManager.createNativeQuery("SELECT balance from bank WHERE account_name=:account_name", Bank.class);
//        query.setParameter("account_name",account_name);
//
//        List<Object[]> results = query.getResultList();
//
//        System.out.println(results);
//        if (query.getResultList().size() == 1 ) {
//
////            return query.getU();
//        }
//
//        return null;
//
//    }

    @Override
    public Bank balance(String account_name) {
        Query query = entityManager.createNativeQuery("select * from bank where account_name = ?", Bank.class);
        query.setParameter(1, account_name);
        query.setMaxResults(1);

        return (Bank) query.getSingleResult();
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

    @Override
    @Transactional
    public void deduct(String accName, int amount) {
        Query query = entityManager.createNativeQuery("UPDATE bank set balance=balance-(?) WHERE account_name=(?)", Bank.class);
        query.setParameter(1, amount);
        query.setParameter(2, accName);
        query.executeUpdate();
    }

}
