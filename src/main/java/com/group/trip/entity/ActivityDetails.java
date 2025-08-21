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
public class ActivityDetails {
    
    @Column(name = "text", columnDefinition = "TEXT")
    private String text;
    
    @Column(name = "description", columnDefinition = "TEXT")
    private String description;
    
    @Column(name = "duration")
    private Integer duration; // duration in minutes
}
