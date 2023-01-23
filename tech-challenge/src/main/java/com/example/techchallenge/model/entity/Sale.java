package com.example.techchallenge.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Set;

@Entity
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDate date;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "fk_client", referencedColumnName = "id")
    @JsonBackReference
    private Client client;
    @OneToMany(cascade = CascadeType.MERGE)
    @JoinColumn(name = "fk_product", referencedColumnName = "id")
    private Set<Product> products;
    private Double totalPrice;
    private int Quantity;

    public Sale(Integer id, LocalDate date, Client client, Set<Product> products) {
        this.id = id;
        this.date = date;
        this.client = client;
        this.products = products;
    }


    public Sale() {
        //no args constructor
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
