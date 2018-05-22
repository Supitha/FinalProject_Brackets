package com.brackets.stockexchange.service;

import com.brackets.stockexchange.model.User;

/**
 * Created by rajith on 5/22/18.
 */
public class UserService {

    public User setUsers() {
        User user = new User();
        user.setId(1);
        user.setUsername("Rajith konara");
        return user;
    }
}
