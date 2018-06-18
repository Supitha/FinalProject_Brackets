package com.brackets.stockexchange.controller;

import com.brackets.stockexchange.model.Broker;
import com.brackets.stockexchange.model.Broker_customer;
import com.brackets.stockexchange.model.User;
import com.brackets.stockexchange.repository.BrokerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/broker")
public class BrokerController {

    @Autowired
    private BrokerRepository brokerRepository;

    @RequestMapping(path="/all", method = RequestMethod.GET)
    public @ResponseBody Iterable<Broker> getAllBrokers() {
        return brokerRepository.findAll();
    }

    @RequestMapping(path = "/customer", method = RequestMethod.POST)
    public @ResponseBody String createNewBrokerCustomer(@RequestBody Broker_customer b_customer) {

        Broker_customer broker_customer = new Broker_customer();
        User user = new User();
        broker_customer.setBroker_name(broker_customer.getBroker_name());
        user.setUsername(b_customer.getCustomer_name());
        brokerRepository.createNewCustomerForBroker(b_customer);
        return "saved";
    }
}
