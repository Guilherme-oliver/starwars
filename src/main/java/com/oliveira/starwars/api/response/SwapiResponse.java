package com.oliveira.starwars.api.response;

import java.util.List;

public class SwapiResponse {
    private List<PlanetResponse> results;

    public List<PlanetResponse> getResults() {
        return results;
    }

    public void setResults(List<PlanetResponse> results) {
        this.results = results;
    }
}