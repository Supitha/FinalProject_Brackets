package com.brackets.stockexchange.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.boot.jackson.JsonComponent;

import javax.persistence.*;

@JsonComponent
@Entity
public class Broker_customer {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "broker_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Broker broker;

    private String customer_name;

    private String stocks;
    private int quantity;
    private int price;
    private int price_sell;
    private int price_bought;

    public Broker_customer() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Broker getBroker() {
        return broker;
    }

    public void setBroker(Broker broker) {
        this.broker = broker;
    }

    public String getStocks() {
        return stocks;
    }

    public void setStocks(String stocks) {
        this.stocks = stocks;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    
    public int getPrice_sell() {
        return price_sell;
    }

    public void setPrice_sell(int price_sell) {
        this.price_sell = price_sell;
    }
       
    public int getPrice_bought() {
        return price_bought;
    }

    public void setPrice_bought(int price_bought) {
        this.price_bought = price_bought;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }
}
