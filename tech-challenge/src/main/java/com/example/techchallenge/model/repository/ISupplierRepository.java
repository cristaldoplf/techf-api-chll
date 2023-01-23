package com.example.techchallenge.model.repository;

import com.example.techchallenge.model.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface ISupplierRepository extends JpaRepository<Supplier, Integer> {
}
