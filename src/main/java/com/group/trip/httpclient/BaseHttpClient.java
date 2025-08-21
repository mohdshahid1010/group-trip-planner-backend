package com.group.trip.httpclient;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class BaseHttpClient {

    @Autowired
    private RestTemplate restTemplate;

    /**
     * Generic GET request method
     */
    public <T> ResponseEntity<T> get(String url, Class<T> responseType, Map<String, String> headers) {
        try {
            HttpHeaders httpHeaders = createHeaders(headers);
            HttpEntity<String> entity = new HttpEntity<>(httpHeaders);
            
            log.info("Making GET request to: {}", url);
            ResponseEntity<T> response = restTemplate.exchange(url, HttpMethod.GET, entity, responseType);
            log.info("GET request successful. Status: {}", response.getStatusCode());
            
            return response;
        } catch (HttpClientErrorException | HttpServerErrorException e) {
            log.error("HTTP error during GET request to {}: {} - {}", url, e.getStatusCode(), e.getResponseBodyAsString());
            throw e;
        } catch (Exception e) {
            log.error("Unexpected error during GET request to {}: {}", url, e.getMessage());
            throw e;
        }
    }

    /**
     * Generic POST request method
     */
    public <T, R> ResponseEntity<R> post(String url, T requestBody, Class<R> responseType, Map<String, String> headers) {
        try {
            HttpHeaders httpHeaders = createHeaders(headers);
            HttpEntity<T> entity = new HttpEntity<>(requestBody, httpHeaders);

            log.info("Making POST request to: {}", url);
            // Use exchange() for generic types
            ResponseEntity<R> response = restTemplate.exchange(url, HttpMethod.POST, entity, responseType);
            log.info("POST request successful. Status: {}", response.getStatusCode());
            return response;
        } catch (HttpClientErrorException | HttpServerErrorException e) {
            log.error("HTTP error during POST request to {}: {} - {}", url, e.getStatusCode(), e.getResponseBodyAsString());
            throw e;
        } catch (Exception e) {
            log.error("Unexpected error during POST request to {}: {}", url, e.getMessage());
            throw e;
        }
    }

    public <T, R> ResponseEntity<R> post(String url, T requestBody, ParameterizedTypeReference<R> responseType, Map<String, String> headers) {
        try {
            HttpHeaders httpHeaders = createHeaders(headers);
            HttpEntity<T> entity = new HttpEntity<>(requestBody, httpHeaders);
            // Using exchange() with ParameterizedTypeReference
            ResponseEntity<R> response = restTemplate.exchange(url, HttpMethod.POST, entity, responseType);
            return response;
        } catch (HttpClientErrorException | HttpServerErrorException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Generic PUT request method
     */
    public <T, R> ResponseEntity<R> put(String url, T requestBody, Class<R> responseType, Map<String, String> headers) {
        try {
            HttpHeaders httpHeaders = createHeaders(headers);
            HttpEntity<T> entity = new HttpEntity<>(requestBody, httpHeaders);
            
            log.info("Making PUT request to: {}", url);
            ResponseEntity<R> response = restTemplate.exchange(url, HttpMethod.PUT, entity, responseType);
            log.info("PUT request successful. Status: {}", response.getStatusCode());
            
            return response;
        } catch (HttpClientErrorException | HttpServerErrorException e) {
            log.error("HTTP error during PUT request to {}: {} - {}", url, e.getStatusCode(), e.getResponseBodyAsString());
            throw e;
        } catch (Exception e) {
            log.error("Unexpected error during PUT request to {}: {}", url, e.getMessage());
            throw e;
        }
    }

    /**
     * Generic DELETE request method
     */
    public <T> ResponseEntity<T> delete(String url, Class<T> responseType, Map<String, String> headers) {
        try {
            HttpHeaders httpHeaders = createHeaders(headers);
            HttpEntity<String> entity = new HttpEntity<>(httpHeaders);
            
            log.info("Making DELETE request to: {}", url);
            ResponseEntity<T> response = restTemplate.exchange(url, HttpMethod.DELETE, entity, responseType);
            log.info("DELETE request successful. Status: {}", response.getStatusCode());
            
            return response;
        } catch (HttpClientErrorException | HttpServerErrorException e) {
            log.error("HTTP error during DELETE request to {}: {} - {}", url, e.getStatusCode(), e.getResponseBodyAsString());
            throw e;
        } catch (Exception e) {
            log.error("Unexpected error during DELETE request to {}: {}", url, e.getMessage());
            throw e;
        }
    }

    /**
     * Create HTTP headers from map
     */
    private HttpHeaders createHeaders(Map<String, String> headers) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        
        if (headers != null && !headers.isEmpty()) {
            headers.forEach(httpHeaders::set);
        }
        
        return httpHeaders;
    }
}
