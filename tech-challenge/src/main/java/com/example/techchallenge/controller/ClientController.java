package com.example.techchallenge.controller;

import com.example.techchallenge.exceptions.ResourceNotFoundException;
import com.example.techchallenge.model.dto.ClientDto;
import com.example.techchallenge.model.dto.ProductDto;
import com.example.techchallenge.model.service.Impl.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/client")
@CrossOrigin
public class ClientController {

    @Autowired
    ClientService clientService;

    @GetMapping("/viewAll")
    public ResponseEntity<?> findAll() throws ResourceNotFoundException {
        Set<ClientDto> clientDtos = clientService.findAll();
        return new ResponseEntity<>(clientDtos, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id) throws ResourceNotFoundException {
        ClientDto clientDto = clientService.findById(id);
        return new ResponseEntity<>(clientDto, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody ClientDto clientDto) {
        ClientDto clientDtoResp = clientService.create(clientDto);
        return new ResponseEntity<>(clientDtoResp, HttpStatus.CREATED);
    }

    @GetMapping("/active/{id}")
    public ResponseEntity<?> active(@PathVariable Integer id) throws ResourceNotFoundException {
        clientService.activeById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) throws ResourceNotFoundException {
        clientService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody ClientDto clientDto) throws ResourceNotFoundException {
        ClientDto clientDtoResp = clientService.update(clientDto);
        return new ResponseEntity<>(clientDtoResp, HttpStatus.OK);
    }
}
