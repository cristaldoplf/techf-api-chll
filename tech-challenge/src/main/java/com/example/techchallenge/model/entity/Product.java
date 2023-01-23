package com.example.techchallenge.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull(message = "name is required")
    private String name;
    @NotNull(message = "description is required")
    private String description;
    @NotNull(message = "price is required")
    private Double price;
    @NotNull(message = "stock is required")
    private Integer stock;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "fk_supplier", referencedColumnName = "id")
    @JsonBackReference
    private Supplier supplier;
    @NotNull(message = "layDown is required")
    private Boolean layDown;

    public Product() {
        //no args constructor
    }

    public Product(Integer id, String name, String description, Double price, Integer stock, Supplier supplier, Boolean layDown) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.supplier = supplier;
        this.layDown = layDown;
    }

    public Boolean getLayDown() {
        return layDown;
    }

    public void setLayDown(Boolean layDown) {
        this.layDown = layDown;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }


}
