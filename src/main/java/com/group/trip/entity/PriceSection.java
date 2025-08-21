package com.group.trip.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PriceSection {

    private Double amount;
    

    private String currency; // e.g., "USD", "EUR", "INR"
}
