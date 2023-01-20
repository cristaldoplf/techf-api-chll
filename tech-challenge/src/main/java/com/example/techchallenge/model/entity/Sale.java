package com.example.techchallenge.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;

@Entity
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Date date;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "fk_client", referencedColumnName = "id", nullable = false)
    @JsonBackReference
    private Client client;
    @OneToMany(cascade = CascadeType.ALL)
    private Set<Product> products;

    public Sale(Integer id, Date date, Client client, Set<Product> products) {
        this.id = id;
        this.date = date;
        this.client = client;
        this.products = products;
    }

    public Sale() {

        //no args constructor
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
