package com.group.trip.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActivityDetails {

    private String text;

    private String description;
    
    private Integer duration; // duration in minutes
}
