package com.brackets.stockexchange.controller;

import com.brackets.stockexchange.model.Broker;
import com.brackets.stockexchange.repository.BrokerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/broker")
public class BrokerController {

    @Autowired
    private BrokerRepository brokerRepository;

    @RequestMapping(path="/all", method = RequestMethod.GET)
    public @ResponseBody Iterable<Broker> getAllBrokers() {
        return brokerRepository.findAll();
    }
}
