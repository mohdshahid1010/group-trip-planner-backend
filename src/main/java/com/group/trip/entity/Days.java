package com.group.trip.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Days {
    @Column(name = "day_number")
    private Integer dayNumber;
    
    @Column(name = "day_date")
    private String dayDate;
    
    @Column(name = "day_title")
    private String dayTitle;
    private Itinerary itinerary;

    private List<Events> events;
}
