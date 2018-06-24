package com.brackets.stockexchange.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.boot.jackson.JsonComponent;

import javax.persistence.*;

@JsonComponent
@Entity
public class Broker_stocks {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    @Transient
    private String cusName;
    
    @Column(unique=true)
    private String stock;
    private int price;
    private int quantity;
    private String broker_name;

    public Broker_stocks() {}
    
    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getBroker_name() {
        return broker_name;
    }

    public void setBroker_name(String broker_name) {
        this.broker_name = broker_name;
    }
}
