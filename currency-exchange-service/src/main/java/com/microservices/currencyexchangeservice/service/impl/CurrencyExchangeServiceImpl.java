package com.microservices.currencyexchangeservice.service.impl;

import com.microservices.currencyexchangeservice.model.CurrencyExchange;
import com.microservices.currencyexchangeservice.repository.CurrencyExchangeRepository;
import com.microservices.currencyexchangeservice.service.CurrencyExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class CurrencyExchangeServiceImpl implements CurrencyExchangeService {

    @Autowired
    private CurrencyExchangeRepository currencyExchangeRepository;


    @Override
    public CurrencyExchange findByFromAndTo(String from, String to) throws RuntimeException {
        CurrencyExchange currencyExchange = currencyExchangeRepository.findByFromAndTo(from, to);
        if(Objects.isNull(currencyExchange)) {
            throw new RuntimeException("enable to find data");
        }

        return currencyExchange;
    }
}
