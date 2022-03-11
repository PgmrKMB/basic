package com.example.basic;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

// @Configuration
@ImportResource("classpath:application.xml")
@ComponentScan(basePackageClasses = BeanConfig.class)
public class BeanConfig {
    @Bean
    public Game game() {
        return new Game();
    }
}