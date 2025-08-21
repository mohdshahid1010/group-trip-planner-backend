package com.group.trip.entity;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BudgetRange {
    @Column(name = "min")
    private int min;
    @Column(name = "max")
    private int max;
}
