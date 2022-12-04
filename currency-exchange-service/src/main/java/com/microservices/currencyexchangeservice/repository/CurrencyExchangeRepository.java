package com.microservices.currencyexchangeservice.repository;

import com.microservices.currencyexchangeservice.model.CurrencyExchange;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Repository;

import java.util.function.Function;

@Repository
public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange, Long> {
    <S extends CurrencyExchange, R> R findByFromAndTo(String from, String to);
}
