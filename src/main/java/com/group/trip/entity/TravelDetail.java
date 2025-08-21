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
public class TravelDetail {
    
    @Column(name = "schedule_type")
    private String type;
    
    @Column(name = "schedule_amount")
    private Double amount;
}
