package com.group.trip.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

@Configuration
public class RestTemplateConfig {

    @Bean
    public RestTemplate restTemplate() {
        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
        
        // Set timeouts
        factory.setConnectTimeout((int) Duration.ofSeconds(10).toMillis());
        factory.setConnectionRequestTimeout((int) Duration.ofSeconds(10).toMillis());
        
        RestTemplate restTemplate = new RestTemplate(factory);
        
        return restTemplate;
    }
    
    @Bean
    public RestTemplate customRestTemplate() {
        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
        
        // Custom timeouts for longer operations
        factory.setConnectTimeout((int) Duration.ofSeconds(30).toMillis());
        factory.setConnectionRequestTimeout((int) Duration.ofSeconds(30).toMillis());
        
        return new RestTemplate(factory);
    }
}
