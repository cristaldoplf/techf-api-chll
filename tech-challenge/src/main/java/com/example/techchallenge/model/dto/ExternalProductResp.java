package com.example.techchallenge.model.dto;

public class ExternalProductResp {
    private String productName;
    private String productCode;
    private int productQuantity;
    private String productImg;

    public ExternalProductResp(String productName, String productCode, int productQuantity, String productImg) {
        this.productName = productName;
        this.productCode = productCode;
        this.productQuantity = productQuantity;
        this.productImg = productImg;
    }

    public ExternalProductResp() {
        //no args-constructor
    }


    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public String getProductImg() {
        return productImg;
    }

    public void setProductImg(String productImg) {
        this.productImg = productImg;
    }
}
