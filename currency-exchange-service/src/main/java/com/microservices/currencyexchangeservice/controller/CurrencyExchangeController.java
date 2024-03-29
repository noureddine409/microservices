package com.microservices.currencyexchangeservice.controller;


import com.microservices.currencyexchangeservice.service.CurrencyExchangeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.currencyexchangeservice.model.CurrencyExchange;

@RestController
@RequestMapping("/currency-exchange")
@Slf4j
public class CurrencyExchangeController {
	
	@Autowired
	private Environment environment;

	@Autowired
	private CurrencyExchangeService currencyExchangeService;

	
	@GetMapping("/from/{from}/to/{to}")
	public CurrencyExchange retrieveExchangeValue(
			@PathVariable("from") String from,
			@PathVariable("to") String to
			) {
		log.info("currency exchange service called");
		CurrencyExchange currencyExchange = currencyExchangeService.findByFromAndTo(from, to);
		String env = environment.getProperty("local.server.port");
		currencyExchange.setEnvironment(env);

		return currencyExchange;
	}
	
	
}
