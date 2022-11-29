package com.microservices.limitsservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.limitsservice.model.Limit;

@RestController
public class LimitsController {
	
	
	@GetMapping("/limits")
	Limit retrieveLimits() {
		return Limit.builder()
				.maximum(6).
				minimum(-2).
				build();
	}

}
