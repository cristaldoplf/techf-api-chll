package com.example.techchallenge.model.service;

import com.example.techchallenge.exceptions.ResourceNotFoundException;

import java.util.Set;

public interface ICRUDService<T> {
    T findById(Integer id) throws ResourceNotFoundException;
    T create(T t);
    void deleteById(Integer id) throws ResourceNotFoundException;
    void activeById(Integer id) throws ResourceNotFoundException;
    T update(T t) throws ResourceNotFoundException;
    Set<T> findAll();
}
