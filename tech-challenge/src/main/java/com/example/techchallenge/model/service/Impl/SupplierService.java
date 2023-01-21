package com.example.techchallenge.model.service.Impl;

import com.example.techchallenge.exceptions.ResourceNotFoundException;
import com.example.techchallenge.model.dto.SupplierDto;
import com.example.techchallenge.model.entity.Supplier;
import com.example.techchallenge.model.repository.ISupplierRepository;
import com.example.techchallenge.model.service.ISupplierService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class SupplierService implements ISupplierService {

    @Autowired
    ISupplierRepository supplierRepository;

    @Autowired
    ModelMapper modelMapper;


    @Override
    public SupplierDto findById(Integer id) throws ResourceNotFoundException {
        Optional<Supplier> supplier = supplierRepository.findById(id);
        if (supplier.isPresent()) {
            return modelMapper.map(supplier, SupplierDto.class);
        }
        throw new ResourceNotFoundException("The supplier with ID: " + id + " does not exist");
    }

    @Override
    public SupplierDto create(SupplierDto supplierDto) {
        Supplier supplierResponse = supplierRepository.save(modelMapper.map(supplierDto, Supplier.class));
        SupplierDto responseSupplierDto = modelMapper.map(supplierResponse, SupplierDto.class);
        return responseSupplierDto;
    }

    @Override
    public void deleteById(Integer id) throws ResourceNotFoundException {
        Optional<Supplier> supplier = supplierRepository.findById(id);
        if (!supplier.isPresent()) {
            throw new ResourceNotFoundException("The supplier with ID " + id + "that you want to delete does not exist.");
        } else {
            supplier.get().setLayDown(true);
            update(modelMapper.map(supplier, SupplierDto.class));
        }
    }

    @Override
    public void activeById(Integer id) throws ResourceNotFoundException {
        Optional<Supplier> supplier = supplierRepository.findById(id);
        if (!supplier.isPresent()) {
            throw new ResourceNotFoundException("The supplier with ID " + id + " that you want recover does not exist");
        } else {
            supplier.get().setLayDown(false);
            update(modelMapper.map(supplier, SupplierDto.class));
        }
    }

    @Override
    public SupplierDto update(SupplierDto supplierDto) throws ResourceNotFoundException {
        Supplier supplier = modelMapper.map(supplierDto, Supplier.class);
        if (supplierRepository.existsById(supplier.getId())) {
            return modelMapper.map(supplierRepository.save(supplier), SupplierDto.class);
        }
        throw new ResourceNotFoundException("The supplier with ID " + supplier.getId() + " that you want to update does not exist.");
    }

    @Override
    public Set<SupplierDto> findAll() {
        List<Supplier> supplierList = supplierRepository.findAll();
        Set<SupplierDto> supplierDtos = new HashSet<>();
        for (Supplier supp : supplierList) {
            supplierDtos.add(modelMapper.map(supp, SupplierDto.class));
        }
        return supplierDtos;
    }
}
