package com.example.techchallenge.model.repository;

import com.example.techchallenge.model.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;



public interface ISupplierRepository extends JpaRepository<Supplier, Integer> {
}
