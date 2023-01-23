package com.example.techchallenge.model.dto;

import jakarta.validation.constraints.NotBlank;

public class SupplierDto {
    private Integer id;
    @NotBlank(message = "The name is required")
    private String name;
    @NotBlank(message = "The Cuit is required")
    private String cuit;
    @NotBlank(message = "The Phone number is required")
    private int phoneNumber;
    @NotBlank(message = "The Adress is required")
    private String adress;
    @NotBlank(message = "The layDown is required")
    private Boolean layDown;

    public SupplierDto(Integer id, String name, String cuit, int phoneNumber, String adress, Boolean layDown) {
        this.id = id;
        this.name = name;
        this.cuit = cuit;
        this.phoneNumber = phoneNumber;
        this.adress = adress;
        this.layDown = layDown;
    }

    public SupplierDto() {
        //no args-cons
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

    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public Boolean getLayDown() {
        return layDown;
    }

    public void setLayDown(Boolean layDown) {
        this.layDown = layDown;
    }
}
