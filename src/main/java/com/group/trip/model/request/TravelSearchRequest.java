package com.group.trip.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TravelSearchRequest {
    
    private String origin;
    private String destination;
    private String departureDate;
    private String returnDate;
    private Integer adults;
    private Integer children;
    private String travelClass; // ECONOMY, PREMIUM_ECONOMY, BUSINESS, FIRST
    private Boolean nonStop;
    private String currency;
    private Integer maxResults;
    
    // Hotel specific fields
    private String checkInDate;
    private String checkOutDate;
    private Integer rooms;
    private String hotelChain;
    private String amenities;
    
    // Common filters
    private Double maxPrice;
    private String sortBy; // PRICE, DURATION, DEPARTURE_TIME
}
