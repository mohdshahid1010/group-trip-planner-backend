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
public class PriceSection {
    
    @Column(name = "amount")
    private Double amount;
    
    @Column(name = "currency", length = 3)
    private String currency; // e.g., "USD", "EUR", "INR"
}
