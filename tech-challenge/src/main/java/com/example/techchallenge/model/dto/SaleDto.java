package com.example.techchallenge.model.dto;

import com.example.techchallenge.model.entity.Client;
import com.example.techchallenge.model.entity.Product;


import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

public class SaleDto {
    private Integer id;
    private LocalDate date;
    private Client client;
    private Set<Product> products;
    private Double totalPrice;
    private int Quantity;

    public SaleDto(Integer id, LocalDate date, Client client, Set<Product> products, Double totalPrice, int quantity) {
        this.id = id;
        this.date = date;
        this.client = client;
        this.products = products;
        this.totalPrice = totalPrice;
        Quantity = quantity;
    }

    public SaleDto() {
        //no args-cons
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
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
