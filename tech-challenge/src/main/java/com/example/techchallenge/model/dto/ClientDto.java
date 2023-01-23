package com.example.techchallenge.model.dto;

import jakarta.validation.constraints.NotNull;

public class ClientDto {
    private Integer id;
    @NotNull(message = "name is required")
    private String name;
    @NotNull(message = "lastName is required")
    private String lastName;
    @NotNull(message = "dni is required")
    private int dni;
    @NotNull(message = "phone number is required")
    private int phoneNumber;
    @NotNull(message = "adress ir required")
    private String adress;
    @NotNull(message = "layDown is required")
    private Boolean layDown;

    public ClientDto() {
        //no args-cons
    }

    public ClientDto(Integer id, String name, String lastName, int dni, int phoneNumber, String adress, Boolean layDown) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.dni = dni;
        this.phoneNumber = phoneNumber;
        this.adress = adress;
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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
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
