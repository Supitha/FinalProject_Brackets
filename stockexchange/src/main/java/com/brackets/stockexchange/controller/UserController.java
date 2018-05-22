package com.brackets.stockexchange.controller;

import com.brackets.stockexchange.model.User;
import com.brackets.stockexchange.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by rajith on 5/22/18.
 */

@RestController
@RequestMapping("/user")
public class UserController {

    UserService userService = new UserService();

    @RequestMapping(method = RequestMethod.GET)
    public User getUsers() {
        User user =  userService.setUsers();
        return user;
    }
}
