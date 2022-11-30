package com.microservices.limitsservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.limitsservice.configuration.Configuration;
import com.microservices.limitsservice.model.Limit;

@RestController
public class LimitsController {
	
	@Autowired
	private Configuration configuration;
	
	@GetMapping("/limits")
	Limit retrieveLimits() {
		
		
		return Limit.builder()
				.maximum(configuration.getMaximum()).
				minimum(configuration.getMinimum()).
				build();
	}

}
