package com.example.techchallenge.controller;

import com.example.techchallenge.exceptions.ResourceNotFoundException;
import com.example.techchallenge.model.dto.ExternalProductDto;
import com.example.techchallenge.model.dto.ProductDto;
import com.example.techchallenge.model.service.Impl.ExternalProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/externalProduct")
@CrossOrigin
public class ExternalProductController {

    @Autowired
    ExternalProductService externalProductService;

    @GetMapping("/viewAll")
    public ResponseEntity<?> findAll() throws ResourceNotFoundException {
        Set<ProductDto> productDtoSet = externalProductService.findAll();
        return new ResponseEntity<>(productDtoSet, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id) throws ResourceNotFoundException {
        ExternalProductDto externalProductDto = externalProductService.findById(id);
        return new ResponseEntity<>(externalProductDto, HttpStatus.OK);
    }
}
