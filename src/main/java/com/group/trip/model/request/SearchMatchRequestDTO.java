package com.group.trip.model.request;

import com.group.trip.entity.Itinerary;
import com.group.trip.entity.SearchCriteria;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SearchMatchRequestDTO {
    private List<Itinerary> itineraries;
    private SearchCriteria searchCriteria;
}
