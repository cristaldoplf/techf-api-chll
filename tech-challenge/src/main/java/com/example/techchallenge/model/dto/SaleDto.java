package com.example.techchallenge.model.dto;

import com.example.techchallenge.model.entity.Client;
import com.example.techchallenge.model.entity.Product;


import java.util.Date;
import java.util.Set;

public class SaleDto {
    private Integer id;
    private Date date;
    private Client client;
    private Set<Product> products;

    public SaleDto(Integer id, Date date, Client client, Set<Product> products) {
        this.id = id;
        this.date = date;
        this.client = client;
        this.products = products;
    }

    public SaleDto() {
        //no args-cons
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}
