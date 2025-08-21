package com.group.trip.service;

import com.group.trip.entity.Itinerary;
import com.group.trip.entity.SearchCriteria;
import com.group.trip.httpclient.BaseHttpClient;
import com.group.trip.model.request.SearchMatchRequestDTO;
import com.group.trip.model.response.SearchResponseDTO;
import com.group.trip.repository.SearchRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import static com.group.trip.utils.HttpClientsUtil.createHeaders;

@Slf4j
@Service
public class SearchService {
    @Autowired
    SearchRepository searchRepository;
    @Autowired
    private BaseHttpClient baseHttpClient;

    @Value("${external.api.python.base-url}")
    private String pythonBase;

    public List<Itinerary> search(SearchCriteria searchCriteria) {
        // fetch from DB
        List<Itinerary> itineraryFromDB = searchRepository.findAll();

        // call ai for fetch details
        Map<String, String> headers = createHeaders();

        try {
            ResponseEntity<List<Itinerary>> itinerariesResponse = baseHttpClient.post(
              pythonBase + "/openai/getCompatibilityScore",
              new SearchMatchRequestDTO(itineraryFromDB, searchCriteria),
              new ParameterizedTypeReference<List<Itinerary>>() {},
              headers
            );

            log.info("Flight search completed successfully");
            return itinerariesResponse.getBody();
        } catch (Exception e) {
            log.error("Error searching flights: {}", e.getMessage());
            throw new RuntimeException("Flight search failed", e);
        }
    }
}
