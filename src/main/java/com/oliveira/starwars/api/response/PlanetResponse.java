package com.oliveira.starwars.api.response;

import com.oliveira.starwars.entities.Film;
import com.oliveira.starwars.entities.Planet;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
public class PlanetResponse {

    private String name;
    private String climate;
    private String terrain;
    private Set<Film> films;
    private int quantityAppearancesInFilms;

    public PlanetResponse(Planet planet) {
        name = planet.getName();
        climate = planet.getClimate();
        terrain = planet.getTerrain();
        films = planet.getFilms();
        quantityAppearancesInFilms = planet.getQuantityAppearancesInFilms();
    }
}