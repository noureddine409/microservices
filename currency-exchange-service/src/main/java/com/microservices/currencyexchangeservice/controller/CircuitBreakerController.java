package com.microservices.currencyexchangeservice.controller;


import com.microservices.currencyexchangeservice.service.CurrencyExchangeService;
import io.github.resilience4j.retry.annotation.Retry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CircuitBreakerController {

    @Autowired
    private CurrencyExchangeService currencyExchangeService;


    @GetMapping("/sample-api")

    public String sampleApi() {
        return currencyExchangeService.fail();

    }



}
