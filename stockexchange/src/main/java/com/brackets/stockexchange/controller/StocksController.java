package com.brackets.stockexchange.controller;

import com.brackets.stockexchange.model.Stocks;
import com.brackets.stockexchange.repository.StocksRepository;
import java.util.ArrayList;
import java.util.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author supithaweerasinghe
 */
@RestController
@RequestMapping("/stocks")
public class StocksController {
    @Autowired
    private StocksRepository stocksRepository;
    
    int updateStocksPricesAlgo() {
        ArrayList sectorTrend = new ArrayList();
        sectorTrend.add(-3);
        sectorTrend.add(-2);
        sectorTrend.add(-1);
        sectorTrend.add(0);
        sectorTrend.add(+1);
        sectorTrend.add(+2);
        sectorTrend.add(+3);
        ArrayList marketTrend = new ArrayList();
        marketTrend.add(-3);
        marketTrend.add(-2);
        marketTrend.add(-1);
        marketTrend.add(0);
        marketTrend.add(+1);
        marketTrend.add(+2);
        marketTrend.add(+3);
        ArrayList randomTrend = new ArrayList();
        randomTrend.add(-2);
        randomTrend.add(-1);
        randomTrend.add(0);
        randomTrend.add(+1);
        randomTrend.add(+2);
        Collections.shuffle(sectorTrend);
        Collections.shuffle(marketTrend);
        Collections.shuffle(randomTrend);
        return (int) sectorTrend.get(0) + (int) marketTrend.get(2) + (int) randomTrend.get(4);
    }

    public void updateStocksPrices() {
        new Thread(new Runnable() {
            public void run() {
                // loop until the thread is interrupted
                while (!Thread.currentThread().isInterrupted()) {
                    for(int i=1;i<21;i++){
                        Stocks stocks = new Stocks();
                         stocks.setPrice(updateStocksPricesAlgo());
                         stocks.setId(i);
                        stocksRepository.updateStocksPrices(stocks);
                    }
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(StocksController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }).start();

    }

    @RequestMapping(path = "/save", method = RequestMethod.POST)
    public @ResponseBody
    String createNewStock(@RequestBody Stocks stocks) {
        stocksRepository.save(stocks);
        return "saved";
    }
    
    @RequestMapping(path = "/stdeviation", method = RequestMethod.POST)
    public @ResponseBody
    String stockDeviation() {
        updateStocksPrices();
        return "stock deviation started";
    }

    @RequestMapping(path = "/all", method = RequestMethod.GET)
    public @ResponseBody
    Iterable<Stocks> findAll() {
        // This returns a JSON or XML with the users
        return stocksRepository.findAll();
    }

}
