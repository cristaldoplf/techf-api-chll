package com.example.techchallenge.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String cuit;
    private int phoneNumber;
    private String adress;
//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "supplier")
//    private Set<Product> products;


    public Supplier() {
        //no args constructor
    }

    public Supplier(Integer id, String name, String cuit, int phoneNumber, String adress) {
        this.id = id;
        this.name = name;
        this.cuit = cuit;
        this.phoneNumber = phoneNumber;
        this.adress = adress;
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
}
