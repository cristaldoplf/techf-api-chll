package com.example.techchallenge.utils;

import com.example.techchallenge.model.service.Impl.ExternalProductService;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TaskScheduling {

    @Autowired
    ExternalProductService externalProductService;

    @Scheduled(fixedRate = 300000)
    public void taskUpdateDatabase() throws UnirestException {
        externalProductService.updateExternalProductInfo();
    }
}
