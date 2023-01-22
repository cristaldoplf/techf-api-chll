package com.example.techchallenge.controller;


import com.example.techchallenge.exceptions.ResourceNotFoundException;
import com.example.techchallenge.model.dto.SaleDto;
import com.example.techchallenge.model.service.Impl.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/sale")
@CrossOrigin
public class SaleController {

    @Autowired
    SaleService saleService;

    @GetMapping("/viewAll")
    public ResponseEntity<?> findAll() throws ResourceNotFoundException {
        Set<SaleDto> saleDtos = saleService.findAll();
        return new ResponseEntity<>(saleDtos, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody SaleDto saleDto){
        SaleDto saleDtoResp = saleService.create(saleDto);
        return new ResponseEntity<>(saleDtoResp, HttpStatus.CREATED);
    }

    //TO-DO
    //consultar ventas de X dia


}
