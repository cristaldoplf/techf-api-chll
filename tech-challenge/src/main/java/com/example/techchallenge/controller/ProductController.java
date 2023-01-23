package com.example.techchallenge.controller;

import com.example.techchallenge.exceptions.ResourceNotFoundException;
import com.example.techchallenge.model.dto.ProductDto;
import com.example.techchallenge.model.service.Impl.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/product")
@CrossOrigin
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/viewAll")
    public ResponseEntity<?> findAll() throws ResourceNotFoundException {
        Set<ProductDto> productDtoSet = productService.findAll();
        return new ResponseEntity<>(productDtoSet, HttpStatus.OK);
    }

    @GetMapping("/find/list/{stock}")
    public ResponseEntity<?> findByStock(@PathVariable Integer stock) throws ResourceNotFoundException {
        Set<ProductDto> productDtoSet = productService.findProductByStock(stock);
        return new ResponseEntity<>(productDtoSet, HttpStatus.OK);
    }

//    @GetMapping("/find/list/supplier/{name}")
//    public ResponseEntity<?> findByStock(@PathVariable String name) throws ResourceNotFoundException {
//        Set<ProductDto> productDtoSet = productService.findProductsBySupplier(name);
//        return new ResponseEntity<>(productDtoSet, HttpStatus.OK);
//    }

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id) throws ResourceNotFoundException {
        ProductDto productDto = productService.findById(id);
        return new ResponseEntity<>(productDto, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody ProductDto productDto) {
        ProductDto productDtoResp = productService.create(productDto);
        return new ResponseEntity<>(productDtoResp, HttpStatus.CREATED);
    }

    @GetMapping("/active/{id}")
    public ResponseEntity<?> active(@PathVariable Integer id) throws ResourceNotFoundException {
        productService.activeById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) throws ResourceNotFoundException {
        productService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody ProductDto productDto) throws ResourceNotFoundException {
        ProductDto productDtoResp = productService.update(productDto);
        return new ResponseEntity<>(productDtoResp, HttpStatus.OK);
    }


}
