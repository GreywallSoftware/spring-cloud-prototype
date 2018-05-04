package com.soschat.web.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

@SpringBootApplication
@EnableEurekaClient
@ComponentScan(basePackages = {"com.soschat.*"})
@EnableCaching
@EntityScan(basePackages = {"com.soschat.object.form"})
@EnableJpaRepositories("com.soschat.object.repository")
public class SoschatWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(SoschatWebApplication.class);
    }
}
