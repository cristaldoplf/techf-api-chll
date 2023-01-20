package com.example.techchallenge.model.repository;

import com.example.techchallenge.model.entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISaleRepository extends JpaRepository<Sale, Integer> {
}
