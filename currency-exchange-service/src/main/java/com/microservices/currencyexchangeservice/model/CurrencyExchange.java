package com.microservices.currencyexchangeservice.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
