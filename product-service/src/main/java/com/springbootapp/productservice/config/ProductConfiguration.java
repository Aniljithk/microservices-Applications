package com.springbootapp.productservice.config;

import com.springbootapp.productservice.event.UuidIdentifiedEntityEventListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductConfiguration {
    @Bean
    public UuidIdentifiedEntityEventListener uuidIdentifiedEntityEventListener() {
        return new UuidIdentifiedEntityEventListener();
    }
}
