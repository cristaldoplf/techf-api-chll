package com.example.techchallenge.model.dto;

import com.example.techchallenge.model.entity.Supplier;
import jakarta.validation.constraints.NotNull;

public class ProductDto {

    private Integer id;
    @NotNull(message = "name is required")
    private String name;
    @NotNull(message = "description is required")
    private String description;
    @NotNull(message = "price is required")
    private Double price;
    @NotNull(message = "stock is required")
    private Integer stock;
    private Supplier supplier;
    @NotNull(message = "layDown is required")
    private Boolean layDown;

    public ProductDto() {
        //no args-cons
    }

    public ProductDto(Integer id, String name, String description, Double price, Integer stock, Supplier supplier, Boolean layDown) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.supplier = supplier;
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

    public Boolean getLayDown() {
        return layDown;
    }

    public void setLayDown(Boolean layDown) {
        this.layDown = layDown;
    }
}
