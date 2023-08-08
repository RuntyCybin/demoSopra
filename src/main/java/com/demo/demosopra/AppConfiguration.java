package com.demo.demosopra;

import io.corp.calculator.TracerImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {

    @Bean
    public TracerImpl tracerBean() {
        return new TracerImpl();
    }
}
