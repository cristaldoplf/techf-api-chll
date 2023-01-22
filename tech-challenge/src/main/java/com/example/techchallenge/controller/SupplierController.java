package com.example.techchallenge.controller;

import com.example.techchallenge.model.dto.ProductDto;
import com.example.techchallenge.model.dto.SupplierDto;
import com.example.techchallenge.model.service.Impl.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/supplier")
@CrossOrigin
public class SupplierController {

    @Autowired
    SupplierService supplierService;

    @GetMapping("/viewAll")
    public ResponseEntity<?> findAll(){
        Set<SupplierDto> supplierDtos = supplierService.findAll();
        return new ResponseEntity<>(supplierDtos, HttpStatus.OK);
    }
}
