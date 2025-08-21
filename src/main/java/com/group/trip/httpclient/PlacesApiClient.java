package com.group.trip.httpclient;

import com.group.trip.model.response.PlacesResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public class PlacesApiClient {

    @Autowired
    private BaseHttpClient baseHttpClient;

    @Value("${external.api.places.base-url:https://maps.googleapis.com/maps/api/place}")
    private String placesApiBaseUrl;

    @Value("${external.api.places.api-key:}")
    private String placesApiKey;

    /**
     * Search for places nearby
     */
    public PlacesResponse searchNearbyPlaces(double latitude, double longitude, int radius, String type) {
        String url = String.format("%s/nearbysearch/json?location=%f,%f&radius=%d&type=%s&key=%s",
                placesApiBaseUrl, latitude, longitude, radius, type, placesApiKey);
        
        Map<String, String> headers = createHeaders();
        
        try {
            ResponseEntity<PlacesResponse> response = baseHttpClient.get(
                url, 
                PlacesResponse.class, 
                headers
            );
            
            log.info("Nearby places search completed successfully for type: {}", type);
            return response.getBody();
        } catch (Exception e) {
            log.error("Error searching nearby places for type {}: {}", type, e.getMessage());
            throw new RuntimeException("Nearby places search failed", e);
        }
    }

    /**
     * Search places by text query
     */
    public PlacesResponse searchPlacesByText(String query) {
        String url = String.format("%s/textsearch/json?query=%s&key=%s",
                placesApiBaseUrl, query.replace(" ", "+"), placesApiKey);
        
        Map<String, String> headers = createHeaders();
        
        try {
            ResponseEntity<PlacesResponse> response = baseHttpClient.get(
                url, 
                PlacesResponse.class, 
                headers
            );
            
            log.info("Text search completed successfully for query: {}", query);
            return response.getBody();
        } catch (Exception e) {
            log.error("Error searching places by text for query {}: {}", query, e.getMessage());
            throw new RuntimeException("Text search failed", e);
        }
    }

    /**
     * Get place details by place ID
     */
    public PlacesResponse getPlaceDetails(String placeId) {
        String url = String.format("%s/details/json?place_id=%s&fields=name,rating,formatted_phone_number,opening_hours,website,reviews&key=%s",
                placesApiBaseUrl, placeId, placesApiKey);
        
        Map<String, String> headers = createHeaders();
        
        try {
            ResponseEntity<PlacesResponse> response = baseHttpClient.get(
                url, 
                PlacesResponse.class, 
                headers
            );
            
            log.info("Place details retrieved successfully for place ID: {}", placeId);
            return response.getBody();
        } catch (Exception e) {
            log.error("Error getting place details for place ID {}: {}", placeId, e.getMessage());
            throw new RuntimeException("Place details retrieval failed", e);
        }
    }

    /**
     * Find place from text
     */
    public PlacesResponse findPlace(String input, String inputType) {
        String url = String.format("%s/findplacefromtext/json?input=%s&inputtype=%s&fields=place_id,name,geometry&key=%s",
                placesApiBaseUrl, input.replace(" ", "+"), inputType, placesApiKey);
        
        Map<String, String> headers = createHeaders();
        
        try {
            ResponseEntity<PlacesResponse> response = baseHttpClient.get(
                url, 
                PlacesResponse.class, 
                headers
            );
            
            log.info("Find place completed successfully for input: {}", input);
            return response.getBody();
        } catch (Exception e) {
            log.error("Error finding place for input {}: {}", input, e.getMessage());
            throw new RuntimeException("Find place failed", e);
        }
    }

    /**
     * Create standard headers
     */
    private Map<String, String> createHeaders() {
        Map<String, String> headers = new HashMap<>();
        headers.put("Accept", "application/json");
        return headers;
    }
}
