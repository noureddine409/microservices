package com.microservices.currencyexchangeservice.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.currencyexchangeservice.model.CurrencyExchange;

@RestController
@RequestMapping("/currency-exchange")
public class CurrencyExchangeController {
	
	@Autowired
	private Environment environment;
	
	@GetMapping("/from/{from}/to/{to}")
	public CurrencyExchange retrieveExchangeValue(
			@PathVariable("from") String from,
			@PathVariable("to") String to
			) {
		
		String env = environment.getProperty("local.server.port");
		return CurrencyExchange.builder()
				.id(1L)
				.from(from)
				.to(to)
				.conversionMultiple(BigDecimal.valueOf(60))
				.environment(env)
				.build();
	}
	
	
}
