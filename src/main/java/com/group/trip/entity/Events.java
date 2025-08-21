package com.group.trip.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class Events {
    private TravelDetail travelDetail;

    private ActivityDetails details;

    private Fare fare;
    
    @Column(name = "type")
    private String type;
    
    @Column(name = "amount")
    private Double amount;

    private Days day;
}
