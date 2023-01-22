package com.example.techchallenge.controller;

import com.example.techchallenge.model.dto.ClientDto;
import com.example.techchallenge.model.dto.SupplierDto;
import com.example.techchallenge.model.service.Impl.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/client")
@CrossOrigin
public class ClientController {

    @Autowired
    ClientService clientService;

    @GetMapping("/viewAll")
    public ResponseEntity<?> findAll(){
        Set<ClientDto> clientDtos = clientService.findAll();
        return new ResponseEntity<>(clientDtos, HttpStatus.OK);
    }
}
