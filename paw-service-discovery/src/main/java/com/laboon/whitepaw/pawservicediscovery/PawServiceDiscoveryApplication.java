package com.laboon.whitepaw.pawservicediscovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class PawServiceDiscoveryApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(PawServiceDiscoveryApplication.class, args);
    }
    
}
