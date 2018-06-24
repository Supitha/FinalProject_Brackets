package com.brackets.stockexchange.controller;

import com.brackets.stockexchange.model.Bank;
import com.brackets.stockexchange.model.User;
import com.brackets.stockexchange.repository.BankRepository;
import com.brackets.stockexchange.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/bank")
public class BankController {

    @Autowired
    private BankRepository bankRepository;
    @Autowired
    private UserRepository userRepository;

    @RequestMapping(path = "/balance", method = RequestMethod.POST)
    public @ResponseBody String balance(@RequestBody User user) {

        if (userRepository.existsByusername(user.getUsername())) {
            Bank bank = bankRepository.balance(user.getUsername());
            return String.valueOf(bank.getBalance());
        } else {
            return "No Account Registered Account";
        }
      }

    @RequestMapping(path = "/list", method = RequestMethod.GET)
    public @ResponseBody Iterable<Bank> getWinner() {
        Bank bank = new Bank();
        return bankRepository.getWinner(bank);
    }
}






