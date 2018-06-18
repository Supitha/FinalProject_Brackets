package com.brackets.stockexchange.controller;

import com.brackets.stockexchange.model.Stocks;
import com.brackets.stockexchange.model.User;
import com.brackets.stockexchange.repository.StocksRepository;
import com.brackets.stockexchange.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 *
 * @author supithaweerasinghe
 */
@RestController
@RequestMapping("/stocks")
public class StocksController {

    @Autowired
    private StocksRepository stocksRepository;

    @RequestMapping(path = "/save", method = RequestMethod.POST)
    public @ResponseBody
    String createNewStock(@RequestBody Stocks stocks) {
        stocksRepository.save(stocks);
        return "saved";
    }

    @RequestMapping(path = "/all", method = RequestMethod.GET)
    public @ResponseBody
    Iterable<Stocks> findAll() {
        // This returns a JSON or XML with the users
        return stocksRepository.findAll();
    }

}
