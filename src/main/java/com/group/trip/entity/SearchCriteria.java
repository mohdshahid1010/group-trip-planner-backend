package com.group.trip.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchCriteria {

    private String source;

    private String destination;

    private String startDate;

    private String endDate;

    private BudgetRange budget;

    private String vibe;
}
