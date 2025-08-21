package com.group.trip.model.response;

import java.time.LocalDateTime;

public class SearchResponseDTO {
    private int id;
    private String itinerary;
    private String description;
    private Double matchingScore;
    private Double price;
    private LocalDateTime start;
    private LocalDateTime end;
    private String source;
    private String destination;
}
