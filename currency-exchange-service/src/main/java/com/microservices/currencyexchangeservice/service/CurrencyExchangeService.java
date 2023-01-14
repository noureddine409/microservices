package com.microservices.currencyexchangeservice.service;


import com.microservices.currencyexchangeservice.model.CurrencyExchange;



public interface CurrencyExchangeService {

    public CurrencyExchange findByFromAndTo(String from, String to) throws RuntimeException ;

    public String fail() ;
}
