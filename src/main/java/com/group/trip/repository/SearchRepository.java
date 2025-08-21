package com.group.trip.repository;

import com.group.trip.entity.Itinerary;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SearchRepository extends MongoRepository<Itinerary, Integer> {
}
