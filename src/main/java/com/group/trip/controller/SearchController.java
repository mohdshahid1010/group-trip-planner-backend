package com.group.trip.controller;

import com.group.trip.entity.Itinerary;
import com.group.trip.entity.SearchCriteria;
import com.group.trip.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/search")
public class SearchController {

    @Autowired
    private SearchService searchService;

    @PostMapping("/")
    public ResponseEntity<List<Itinerary>> search(@RequestBody SearchCriteria searchCriteria) {
        List<Itinerary> response =  searchService.search(searchCriteria);
        return ResponseEntity.status(HttpStatus.OK)
          .body(response);
    }

    @GetMapping("/health")
    public String health() {
        return "Working";
    }

}
