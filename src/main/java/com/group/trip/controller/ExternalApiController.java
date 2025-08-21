package com.group.trip.controller;

import com.group.trip.model.request.TravelSearchRequest;
import com.group.trip.model.response.PlacesResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@Slf4j
@RestController
@RequestMapping("/api/external")
public class ExternalApiController {

    @Autowired
    private ExternalApiService externalApiService;

    /**
     * Search for flights
     */
    @PostMapping("/flights/search")
    public ResponseEntity<TravelSearchResponse> searchFlights(@RequestBody TravelSearchRequest request) {
        log.info("Received flight search request from {} to {}", request.getOrigin(), request.getDestination());
        
        try {
            TravelSearchResponse response = externalApiService.searchFlights(request);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            log.error("Error searching flights: {}", e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    /**
     * Search for hotels
     */
    @PostMapping("/hotels/search")
    public ResponseEntity<TravelSearchResponse> searchHotels(@RequestBody TravelSearchRequest request) {
        log.info("Received hotel search request for {}", request.getDestination());
        
        try {
            TravelSearchResponse response = externalApiService.searchHotels(request);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            log.error("Error searching hotels: {}", e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    /**
     * Get current weather for a city
     */
    @GetMapping("/weather/{city}")
    public ResponseEntity<WeatherResponse> getWeather(@PathVariable String city) {
        log.info("Received weather request for {}", city);
        
        try {
            WeatherResponse response = externalApiService.getWeather(city);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            log.error("Error getting weather for {}: {}", city, e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    /**
     * Search for places/attractions
     */
    @GetMapping("/places/search")
    public ResponseEntity<PlacesResponse> searchPlaces(@RequestParam String query) {
        log.info("Received places search request for: {}", query);
        
        try {
            PlacesResponse response = externalApiService.searchPlaces(query);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            log.error("Error searching places for {}: {}", query, e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    /**
     * Get nearby places by coordinates
     */
    @GetMapping("/places/nearby")
    public ResponseEntity<PlacesResponse> getNearbyPlaces(
            @RequestParam double latitude,
            @RequestParam double longitude,
            @RequestParam(defaultValue = "1000") int radius,
            @RequestParam(defaultValue = "tourist_attraction") String type) {
        
        log.info("Received nearby places request for coordinates: {}, {} with radius: {} and type: {}", 
                latitude, longitude, radius, type);
        
        try {
            PlacesResponse response = externalApiService.getNearbyPlaces(latitude, longitude, radius, type);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            log.error("Error getting nearby places: {}", e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    /**
     * Get destination insights (comprehensive information)
     */
    @GetMapping("/destination/insights/{destination}")
    public CompletableFuture<ResponseEntity<String>> getDestinationInsights(@PathVariable String destination) {
        log.info("Received destination insights request for: {}", destination);
        
        return externalApiService.getDestinationInsights(destination)
                .thenApply(ResponseEntity::ok)
                .exceptionally(ex -> {
                    log.error("Error getting destination insights for {}: {}", destination, ex.getMessage());
                    return ResponseEntity.internalServerError().build();
                });
    }

    /**
     * Complete travel search (flights + hotels + weather + places)
     */
    @PostMapping("/travel/complete")
    public CompletableFuture<ResponseEntity<TravelSearchResponse>> searchCompleteTravel(@RequestBody TravelSearchRequest request) {
        log.info("Received complete travel search request from {} to {}", request.getOrigin(), request.getDestination());
        
        return externalApiService.searchCompleteTravel(request)
                .thenApply(ResponseEntity::ok)
                .exceptionally(ex -> {
                    log.error("Error in complete travel search: {}", ex.getMessage());
                    return ResponseEntity.internalServerError().build();
                });
    }

    /**
     * Health check for external APIs
     */
    @GetMapping("/health")
    public ResponseEntity<String> healthCheck() {
        log.info("External API health check requested");
        
        try {
            // You can implement actual health checks here
            // For now, returning a simple success message
            return ResponseEntity.ok("External API services are healthy");
        } catch (Exception e) {
            log.error("External API health check failed: {}", e.getMessage());
            return ResponseEntity.internalServerError().body("External API services are unhealthy");
        }
    }
}
