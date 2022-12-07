package com.microservices.apigateway.config;

import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.Buildable;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import java.util.function.Function;

@Configuration
public class ApiGatewayConfig {

    private Function<PredicateSpec, Buildable<Route>> routeFunction
            = predicateSpec -> predicateSpec.path("/get")
            .filters(f -> f.addRequestHeader("myHeader", "myURI"))
            .uri("http://httpbin.org:80");

    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder routeLocatorBuilder) {
        return routeLocatorBuilder.routes().route(routeFunction)
                .route(predicateSpec -> predicateSpec.path("/currency-exchange/**")
                        .uri("lb://currency-exchange-service")
                )
                .build();
    }

}
