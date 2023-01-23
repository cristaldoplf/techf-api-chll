package com.example.techchallenge.model.repository;

import com.example.techchallenge.model.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;



public interface IClientRepository extends JpaRepository<Client, Integer> {
}
