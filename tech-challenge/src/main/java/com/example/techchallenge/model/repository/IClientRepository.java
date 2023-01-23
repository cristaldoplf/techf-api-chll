package com.example.techchallenge.model.repository;

import com.example.techchallenge.model.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface IClientRepository extends JpaRepository<Client, Integer> {
}
