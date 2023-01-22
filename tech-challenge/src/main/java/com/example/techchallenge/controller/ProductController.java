package com.example.techchallenge.controller;

import com.example.techchallenge.model.dto.ProductDto;
import com.example.techchallenge.model.service.Impl.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/product")
@CrossOrigin
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/viewAll")
    public ResponseEntity<?> findAll(){
        Set<ProductDto> productDtoSet = productService.findAll();
        return new ResponseEntity<>(productDtoSet, HttpStatus.OK);
    }
}
