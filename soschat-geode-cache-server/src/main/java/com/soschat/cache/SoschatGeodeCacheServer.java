package com.soschat.cache;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.gemfire.config.annotation.CacheServerApplication;
import org.springframework.data.gemfire.config.annotation.EnableLocator;
import org.springframework.data.gemfire.config.annotation.EnableManager;

@SpringBootApplication
@CacheServerApplication(locators = "localhost[10334]")
public class SoschatGeodeCacheServer {
    public static void main(String[] args) {
        new SpringApplicationBuilder(SoschatGeodeCacheServer.class).web(false).build().run(args);
    }

    @Configuration
    @EnableLocator
    @EnableManager(start = true)
    // @Profile("locator-manager")
    static class LocationManagerConfiguration {

    }
}
