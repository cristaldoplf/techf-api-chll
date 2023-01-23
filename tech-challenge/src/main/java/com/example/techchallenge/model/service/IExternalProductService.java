package com.example.techchallenge.model.service;

import com.example.techchallenge.exceptions.ResourceNotFoundException;

import java.util.Set;

public interface IExternalProductService<T> {
    T findById(Integer id) throws ResourceNotFoundException;
    Set<T> findAll() throws ResourceNotFoundException;
}
