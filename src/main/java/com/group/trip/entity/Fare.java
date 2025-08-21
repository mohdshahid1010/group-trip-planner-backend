package com.group.trip.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Fare {
    
    @Column(name = "fare_type")
    private String type; // e.g., "travel", "events", "accommodation"
    
    @Column(name = "fare_amount")
    private Double amount;
}
