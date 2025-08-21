package com.group.trip.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Fare {

    private String type; // e.g., "travel", "events", "accommodation"
    

    private Double amount;
}
