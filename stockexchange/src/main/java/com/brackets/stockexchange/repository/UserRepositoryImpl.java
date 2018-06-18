package com.brackets.stockexchange.repository;

import com.brackets.stockexchange.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Repository
public class UserRepositoryImpl implements UserRepositoryCustom {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public boolean  existsByusername(String username) {
        Query query = entityManager.createNativeQuery("SELECT *from USER WHERE username=:username", User.class);
        query.setParameter("username", username);

        if (query.getResultList().size() == 1 ) {
            return true;
        }
        return false;
    }
}
