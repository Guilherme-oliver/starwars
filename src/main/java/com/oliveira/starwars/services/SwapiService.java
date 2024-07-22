package com.oliveira.starwars.services;

import com.oliveira.starwars.api.response.PlanetResponse;
import com.oliveira.starwars.api.response.SwapiResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class SwapiService {

    @Value("${swapi.base.url}")
    private String baseUrl;

    private final RestTemplate restTemplate;

    public SwapiService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public PlanetResponse getPlanetByName(String name) {
        String url = UriComponentsBuilder.fromHttpUrl(baseUrl + "/planets/")
                .queryParam("search", name)
                .toUriString();
        SwapiResponse response = restTemplate.getForObject(url, SwapiResponse.class);
        return response != null && response.getResults() != null && !response.getResults().isEmpty()
                ? response.getResults().get(0)
                : null;
    }
}