package com.soschat.discovery.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SoschatDiscoveryServer {

    public static void main(String[] args) {
        SpringApplication.run(SoschatDiscoveryServer.class, args);
    }
}
