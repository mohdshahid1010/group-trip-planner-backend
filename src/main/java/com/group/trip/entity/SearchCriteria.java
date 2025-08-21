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
public class SearchCriteria {
    
    @Column(name = "source")
    private String source;
    
    @Column(name = "destination")
    private String destination;
    
    @Column(name = "start_date")
    private String startDate;
    
    @Column(name = "end_date")
    private String endDate;
    
    @Column(name = "budget")
    private BudgetRange budget;
    
    @Column(name = "vibe")
    private String vibe;
}
