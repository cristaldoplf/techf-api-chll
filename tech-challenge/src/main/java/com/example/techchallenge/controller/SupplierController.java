package com.example.techchallenge.controller;

import com.example.techchallenge.exceptions.ResourceNotFoundException;
import com.example.techchallenge.model.dto.SupplierDto;
import com.example.techchallenge.model.service.Impl.SupplierService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/supplier")
@CrossOrigin
public class SupplierController {

    @Autowired
    SupplierService supplierService;

    @GetMapping("/viewAll")
    public ResponseEntity<?> findAll() throws ResourceNotFoundException {
        Set<SupplierDto> supplierDtos = supplierService.findAll();
        return new ResponseEntity<>(supplierDtos, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id) throws ResourceNotFoundException {
        SupplierDto supplierDto = supplierService.findById(id);
        return new ResponseEntity<>(supplierDto, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create (@Valid @RequestBody SupplierDto supplierDto){
        SupplierDto supplierDtoResp = supplierService.create(supplierDto);
        return new ResponseEntity<>(supplierDtoResp, HttpStatus.CREATED);
    }

    @GetMapping("/active/{id}")
    public ResponseEntity<?> active(@PathVariable Integer id) throws ResourceNotFoundException {
        supplierService.activeById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) throws ResourceNotFoundException {
        supplierService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody SupplierDto supplierDto) throws ResourceNotFoundException {
        SupplierDto supplierDtoResp = supplierService.update(supplierDto);
        return new ResponseEntity<>(supplierDtoResp, HttpStatus.OK);
    }


}
