package com.brackets.stockexchange.repository;

/**
 * Created by rajith on 6/18/18.
 */
public interface UserRepositoryCustom {
    boolean existsByusername(String username);
    boolean checklogin(String username, String password);
}
