package com.soschat.web.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.gemfire.cache.config.EnableGemfireCaching;
import org.springframework.data.gemfire.config.annotation.*;
import org.springframework.data.gemfire.repository.config.EnableGemfireRepositories;

@SpringBootApplication
@EnableEurekaClient
@ComponentScan(basePackages = {"com.soschat.*"})
@ClientCacheApplication(name = "SoschatGeodeCacheClient")
@EnableClusterConfiguration(useHttp = true)
@EnableEntityDefinedRegions(basePackages = {"com.soschat.object.form"})
@EnableCachingDefinedRegions
@EnableGemfireRepositories(basePackages = {"com.soschat.object.repository"})
@EnablePdx
@EnableGemfireCaching
public class SoschatWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(SoschatWebApplication.class);
    }
}
