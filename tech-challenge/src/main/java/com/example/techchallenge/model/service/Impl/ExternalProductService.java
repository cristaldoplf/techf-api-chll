package com.example.techchallenge.model.service.Impl;

import com.example.techchallenge.exceptions.ResourceNotFoundException;
import com.example.techchallenge.model.dto.ExternalProductDto;
import com.example.techchallenge.model.dto.ExternalProductResp;
import com.example.techchallenge.model.dto.ProductDto;
import com.example.techchallenge.model.entity.ExternalProduct;
import com.example.techchallenge.model.entity.Product;
import com.example.techchallenge.model.repository.IExternalProductRepository;
import com.example.techchallenge.model.service.IExternalProductService;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ExternalProductService implements IExternalProductService {

    @Autowired
    IExternalProductRepository externalProductRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public ExternalProductDto findById(Integer id) throws ResourceNotFoundException {
        Optional<ExternalProduct> product = externalProductRepository.findById(id);
        if (product.isPresent()) {
            return modelMapper.map(product, ExternalProductDto.class);
        }
        throw new ResourceNotFoundException("The External Product with ID: " + id + " does not exist");
    }

    @Override
    public Set findAll() throws ResourceNotFoundException {
        List<ExternalProduct> externalProductList = externalProductRepository.findAll();
        Set<ExternalProductDto> externalProductDtos = new HashSet<>();
        for (ExternalProduct ext : externalProductList) {
            externalProductDtos.add(modelMapper.map(ext, ExternalProductDto.class));
        }
        if (externalProductDtos.size() < 1) {
            throw new ResourceNotFoundException("There is no products available");
        }
        return externalProductDtos;
    }

    public void updateAllExternalProduct(List<ExternalProductResp> externalProductList) {
        Set<ExternalProduct> externalProductSet = new HashSet<>();

        for (ExternalProductResp ext : externalProductList) {
            ExternalProduct externalProduct = new ExternalProduct();
            externalProduct.setName(ext.getProductName());
            externalProduct.setSku(ext.getProductCode());
            externalProduct.setStock(ext.getProductQuantity());
            externalProduct.setImgUrl(ext.getProductImg());

            externalProductSet.add(externalProduct);
        }

        externalProductRepository.deleteAll();
        externalProductRepository.saveAll(externalProductSet);
    }

    public void updateExternalProductInfo() throws UnirestException {
        HttpResponse<String> response = Unirest.get("http://demo8655486.mockable.io/product").asString();

        Gson gson = new Gson();

        Type listType = new TypeToken<List<ExternalProductResp>>() {
        }.getType();
        List<ExternalProductResp> externalProductList;
        externalProductList = gson.fromJson(response.getBody(), listType);

        updateAllExternalProduct(externalProductList);
    }


}
