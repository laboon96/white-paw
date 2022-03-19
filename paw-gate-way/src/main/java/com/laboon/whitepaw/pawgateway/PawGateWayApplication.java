package com.laboon.whitepaw.pawgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class PawGateWayApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(PawGateWayApplication.class, args);
    }
    
}
