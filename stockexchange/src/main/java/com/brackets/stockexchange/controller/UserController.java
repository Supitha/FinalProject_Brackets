package com.brackets.stockexchange.controller;

import com.brackets.stockexchange.model.Bank;
import com.brackets.stockexchange.model.User;
import com.brackets.stockexchange.repository.AIRepository;
import com.brackets.stockexchange.repository.BankRepository;
import com.brackets.stockexchange.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * Created by rajith on 5/22/18.
 */

@RestController
@RequestMapping("/user")
public class UserController {

    /**
     * @Autowired get the bean userRepository
     */
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BankRepository bankRepository;
    @Autowired
    private AIRepository aiRepository ;

    @RequestMapping(path = "/save", method = RequestMethod.POST)
    public @ResponseBody String createNewUser(@RequestBody User user) {

        if (!userRepository.existsByusername(user.getUsername())) {
            userRepository.save(user);
            Bank bank = new Bank();
            bank.setAccount_name(user.getUsername());
            bank.setBalance(1000);
            bankRepository.createNewAccountForUser(bank);
            aiRepository.createBankAccountAI();//AI account creation
            return "Saved";
        } else {
            return "User already exists";
        }
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<User> getUser(@PathVariable("id") Integer id) {
       Optional<User> user = userRepository.findById(id);
       return  user;
    }

    @RequestMapping(path="/all", method = RequestMethod.GET)
    public @ResponseBody Iterable<User> getAllUsers() {
        // This returns a JSON or XML with the users
        return userRepository.findAll();
    }

    @RequestMapping(path="/login", method = RequestMethod.POST)
    public @ResponseBody boolean login(@RequestBody User user) {

        if (userRepository.checklogin(user.getUsername(), user.getPassword())) {
            return true;
        }else {
            return false;
        }
    }
}
