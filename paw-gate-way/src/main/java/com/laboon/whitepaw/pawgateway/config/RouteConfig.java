package com.laboon.whitepaw.pawgateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouteConfig {
    
    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("user-interface", r -> r.path("/users/**")
                        .uri("lb://USER-INTERFACE"))
                .route("crawling-interface", r -> r.path("/users/**")
                        .uri("lb://CRAWLING-INTERFACE"))
                .build();
    }
}
