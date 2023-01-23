package com.example.techchallenge.model.dto;

public class ExternalProductDto {
    private Integer id;
    private String name;
    private String sku;
    private int stock;
    private String imgUrl;

    public ExternalProductDto(Integer id, String name, String sku, int stock, String imgUrl) {
        this.id = id;
        this.name = name;
        this.sku = sku;
        this.stock = stock;
        this.imgUrl = imgUrl;
    }

    public ExternalProductDto() {
        //no args-constructor
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

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
