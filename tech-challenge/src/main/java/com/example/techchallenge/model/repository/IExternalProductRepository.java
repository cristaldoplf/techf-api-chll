package com.example.techchallenge.model.repository;

import com.example.techchallenge.model.entity.ExternalProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IExternalProductRepository extends JpaRepository<ExternalProduct, Integer> {
}
