/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brackets.stockexchange.repository;

import com.brackets.stockexchange.model.Bank;
import com.brackets.stockexchange.model.Broker_stocks;
import com.brackets.stockexchange.model.Stocks;
import com.brackets.stockexchange.model.User;
import java.util.ArrayList;
import java.util.Collections;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author supithaweerasinghe
 */
public class AIRepositoryImpl implements AIRepositoryCustom{

    @PersistenceContext
    EntityManager entityManager;
    
    @Autowired
    private BankRepository bankRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BrokerRepository brokerRepository;
    
    String[] companyList = {};
    
    @Override
    public Stocks selectCompany(Stocks st) {
        Query query = entityManager.createNativeQuery("select * from stocks where id = ?", Stocks.class);
        query.setParameter(1, st.getId());
        query.setMaxResults(1);

        return (Stocks) query.getSingleResult();
    }
    
    @Override
    public Broker_stocks selectBroker(Stocks st) {
        Query query = entityManager.createNativeQuery("select * from broker_stocks where stock = ?", Broker_stocks.class);
        query.setParameter(1, st.getStockName());
        query.setMaxResults(1);

        return (Broker_stocks) query.getSingleResult();
    }
    
    @Override
        public String createBankAccountAI() {
        if (!userRepository.existsByusername("John")) {
            User user = new User();
            user.setEmail("ai1@st.com");
            user.setPassword("AI1");
            user.setUsername("John");
            userRepository.save(user);
            Bank bank = new Bank();
            bank.setAccount_name("John");
            bank.setBalance(1000);
            bankRepository.createNewAccountForUser(bank);
            return "Saved";
        } else {
            System.out.print("AI already exists");
            return "AI already exists";
        }
    }

    @Override
    public Broker_stocks selectCompanyAI() {
        ArrayList id = new ArrayList();
        for (int x = 1; x <= 20; x++) {
            id.add(x);
        }
        Collections.shuffle(id);
        int selected = (int) id.get(1);
        Stocks st = new Stocks();
        st.setId(selected);
        Broker_stocks res = selectBroker(selectCompany(st));
        return res;
    }
    
    @Override
    public void buyStocksAI(){
        ArrayList qty = new ArrayList();
        qty.add(1);
        qty.add(2);
        qty.add(3);
        qty.add(4);
        Collections.shuffle(qty);
        Broker_stocks st = selectCompanyAI();
        st.setQuantity((int)qty.get(0));
        st.setCusName("John");
        brokerRepository.checkQty(st);
    }
    
}
