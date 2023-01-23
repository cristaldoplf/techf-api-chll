package com.example.techchallenge.model.service.Impl;

import com.example.techchallenge.exceptions.ResourceNotFoundException;
import com.example.techchallenge.model.dto.SaleDto;
import com.example.techchallenge.model.entity.Sale;
import com.example.techchallenge.model.repository.ISaleRepository;
import com.example.techchallenge.model.service.ISaleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
public class SaleService implements ISaleService {

    @Autowired
    ISaleRepository saleRepository;

    @Autowired
    ModelMapper modelMapper;


    @Override
    public SaleDto findById(Integer id) throws ResourceNotFoundException {
        return null;
    }

    @Override
    public SaleDto create(SaleDto saleDto) {
        Sale saleResponse = saleRepository.save(modelMapper.map(saleDto, Sale.class));
        SaleDto saleResponseDto = modelMapper.map(saleResponse, SaleDto.class);
        return saleResponseDto;
    }

    @Override
    public void deleteById(Integer id) throws ResourceNotFoundException {

    }

    @Override
    public void activeById(Integer id) throws ResourceNotFoundException {

    }

    @Override
    public SaleDto update(SaleDto saleDto) throws ResourceNotFoundException {
        return null;
    }

    @Override
    public Set<SaleDto> findAll() throws ResourceNotFoundException {
        List<Sale> saleList = saleRepository.findAll();
        Set<SaleDto> saleDtos = new HashSet<>();
        for (Sale sal : saleList) {
            saleDtos.add(modelMapper.map(sal, SaleDto.class));
        }

        if (saleDtos.size() < 1) {
            throw new ResourceNotFoundException("There is no sales available");
        }
        return saleDtos;
    }

    public Set<SaleDto> findSalesByDate(LocalDate date) throws ResourceNotFoundException {
        Set<SaleDto> saleDtos = new HashSet<>();
        List<Sale> sales = saleRepository.findSalesByDate(date);

        if (sales.size() < 1){
            throw new ResourceNotFoundException("There are no sales that Day");
        }
        for (Sale sale : sales) {
            saleDtos.add(modelMapper.map(sale,SaleDto.class));
        }

        return saleDtos;

    }

//    public Set<SaleDto> findSalesBySupplierName(Integer id) throws ResourceNotFoundException {
//        Set<SaleDto> saleDtos = new HashSet<>();
//        List<Sale> sales = saleRepository.findSalesBySupplierName(id);
//
//        if (sales.size() < 1){
//            throw new ResourceNotFoundException("There are no sales for that search");
//        }
//        for (Sale sale : sales) {
//            saleDtos.add(modelMapper.map(sale,SaleDto.class));
//        }
//        return saleDtos;
//    }

}
