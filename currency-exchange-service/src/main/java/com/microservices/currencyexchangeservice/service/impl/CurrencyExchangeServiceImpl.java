package com.microservices.currencyexchangeservice.service.impl;

import com.microservices.currencyexchangeservice.controller.CircuitBreakerController;
import com.microservices.currencyexchangeservice.model.CurrencyExchange;
import com.microservices.currencyexchangeservice.repository.CurrencyExchangeRepository;
import com.microservices.currencyexchangeservice.service.CurrencyExchangeService;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;

@Service
public class CurrencyExchangeServiceImpl implements CurrencyExchangeService {

    @Autowired
    private CurrencyExchangeRepository currencyExchangeRepository;

    private Logger logger =
            LoggerFactory.getLogger(CircuitBreakerController.class);


    @Override
    public CurrencyExchange findByFromAndTo(String from, String to) throws RuntimeException {
        CurrencyExchange currencyExchange = currencyExchangeRepository.findByFromAndTo(from, to);
        if(Objects.isNull(currencyExchange)) {
            throw new RuntimeException("enable to find data");
        }

        return currencyExchange;
    }


    @Retry(name = "sample-api")
    @Override
    public String fail() {
        logger.info("Sample Api call receieved");
        ResponseEntity<String> forEntity = new RestTemplate().getForEntity("http://localhost:8080/some-dummy-url", String.class);
        return forEntity.getBody();
    }
}
