package com.microservices.currencyexchangeservice.model;

import java.math.BigDecimal;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "currency_exchange")
public class CurrencyExchange {
	
	@Id
	private Long id;

	@Column(name = "valueFrom")
	private String from;
	@Column(name = "valueTo")
	private String to;
	private BigDecimal conversionMultiple;
	private String environment;
}
