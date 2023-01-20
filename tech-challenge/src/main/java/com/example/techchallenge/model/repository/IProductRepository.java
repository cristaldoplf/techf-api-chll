package com.example.techchallenge.model.repository;

import com.example.techchallenge.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<Product, Integer> {
}
