package com.example.techchallenge.controller;


import com.example.techchallenge.exceptions.ResourceNotFoundException;
import com.example.techchallenge.model.dto.SaleDto;
import com.example.techchallenge.model.service.Impl.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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

    @GetMapping("/find/date/{date}")
    public ResponseEntity<?> findByDate(@PathVariable String date) throws ResourceNotFoundException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate convertedDate = LocalDate.parse(date, formatter);
        Set<SaleDto> saleDtos = saleService.findSalesByDate(convertedDate);

        return new ResponseEntity<>(saleDtos, HttpStatus.OK);
    }

//    @GetMapping("/find/{id}")
//    public ResponseEntity<?> findBySupplierName(@PathVariable Integer id) throws ResourceNotFoundException {
//        Set<SaleDto> saleDtos = saleService.findSalesBySupplierName(id);
//        return new ResponseEntity<>(saleDtos, HttpStatus.OK);
//    }



}
