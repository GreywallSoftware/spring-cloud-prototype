package com.soschat.gateway.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class SoschatZuulServer {

    public static void main(String[] args) {
        new SpringApplicationBuilder(SoschatZuulServer.class).run(args);
    }

}
