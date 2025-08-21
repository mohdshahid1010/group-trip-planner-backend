package com.group.trip.entity;


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

    private Integer dayNumber;
    

    private String dayDate;
    

    private String dayTitle;
    private Itinerary itinerary;

    private List<Events> events;
}
