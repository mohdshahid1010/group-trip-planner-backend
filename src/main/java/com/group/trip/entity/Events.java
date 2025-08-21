package com.group.trip.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class Events {
    private TravelDetail travelDetail;

    private ActivityDetails details;

    private Fare fare;
    

    private String type;
    

    private Double amount;

    private Days day;
}
