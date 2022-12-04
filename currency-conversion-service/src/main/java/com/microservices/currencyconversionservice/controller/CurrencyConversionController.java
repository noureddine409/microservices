package com.microservices.currencyconversionservice.controller;


import com.microservices.currencyconversionservice.model.CurrencyConversion;
import com.microservices.currencyconversionservice.proxy.CurrencyExchangeProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/currency-conversion")
public class CurrencyConversionController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private CurrencyExchangeProxy currencyExchangeProxy;

    @GetMapping("/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion calculateCurrencyConversion(@PathVariable("from") String from,
                                                          @PathVariable("to") String to,
                                                          @PathVariable("quantity") BigDecimal quantity) {
        Map<String, String> uriParams = new HashMap<String, String>();
        uriParams.put("from", from);
        uriParams.put("to", to);
        CurrencyConversion currencyConversion = restTemplate.getForEntity(
                "http://localhost:8000/currency-exchange/from/{from}/to/{to}",
                CurrencyConversion.class,
                uriParams
        ).getBody();

        return CurrencyConversion.builder()
                .id(currencyConversion.getId())
                .from(from)
                .to(to)
                .conversionMultiple(currencyConversion.getConversionMultiple())
                .totalCalculatedAmounted(quantity.multiply(currencyConversion.getConversionMultiple()))
                .quantity(quantity)
                .environment(currencyConversion.getEnvironment())
                .build();
    }

    @GetMapping("/feign/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion calculateCurrencyConversionFeign(@PathVariable("from") String from,
                                                          @PathVariable("to") String to,
                                                          @PathVariable("quantity") BigDecimal quantity) {

        CurrencyConversion currencyConversion = currencyExchangeProxy.retrieveExchangeValue(from, to);

        return CurrencyConversion.builder()
                .id(currencyConversion.getId())
                .from(from)
                .to(to)
                .conversionMultiple(currencyConversion.getConversionMultiple())
                .totalCalculatedAmounted(quantity.multiply(currencyConversion.getConversionMultiple()))
                .quantity(quantity)
                .environment(currencyConversion.getEnvironment())
                .build();
    }

}
