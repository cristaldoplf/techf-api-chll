package com.example.techchallenge.model.service.Impl;


import com.example.techchallenge.exceptions.ResourceNotFoundException;
import com.example.techchallenge.model.dto.ProductDto;
import com.example.techchallenge.model.entity.Product;
import com.example.techchallenge.model.repository.IProductRepository;
import com.example.techchallenge.model.service.IProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;


@Service
public class ProductService implements IProductService {


    @Autowired
    IProductRepository productRepository;

    @Autowired
    ModelMapper modelMapper;


    @Override
    public ProductDto findById(Integer id) throws ResourceNotFoundException {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            return modelMapper.map(product, ProductDto.class);
        }
        throw new ResourceNotFoundException("The product with ID: " + id + " does not exist");
    }

    @Override
    public ProductDto create(ProductDto productDto) {
        Product productResponse = productRepository.save(modelMapper.map(productDto, Product.class));
        ProductDto responseProductDto = modelMapper.map(productResponse, ProductDto.class);
        return responseProductDto;
    }

    @Override
    public void deleteById(Integer id) throws ResourceNotFoundException {
        Optional<Product> product = productRepository.findById(id);
        if (!product.isPresent()) {
            throw new ResourceNotFoundException("The product with ID " + id + " that you want delete does not exists.");
        } else {
            product.get().setLayDown(true);
            update(modelMapper.map(product, ProductDto.class));
        }
    }

    @Override
    public void activeById(Integer id) throws ResourceNotFoundException {
        Optional<Product> product = productRepository.findById(id);
        if (!product.isPresent()) {
            throw new ResourceNotFoundException("The product with ID " + id + " that you want recover does not exists.");
        } else {
            product.get().setLayDown(false);
            update(modelMapper.map(product, ProductDto.class));
        }
    }

    @Override
    public ProductDto update(ProductDto productDto) throws ResourceNotFoundException {
        Product product = modelMapper.map(productDto, Product.class);
        if (productRepository.existsById(product.getId())){
            return modelMapper.map(productRepository.save(product), ProductDto.class);
        }
        throw new ResourceNotFoundException("The product with ID "+ product.getId() +" that you want update does not exists.");
    }

    @Override
    public Set<ProductDto> findAll() {
        List<Product> productList = productRepository.findAll();
        Set<ProductDto> productDtos = new HashSet<>();
        for (Product prod: productList) {
            productDtos.add(modelMapper.map(prod, ProductDto.class));
        }
        return productDtos;
    }
}
