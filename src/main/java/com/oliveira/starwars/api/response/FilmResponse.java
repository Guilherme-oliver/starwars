package com.oliveira.starwars.api.response;

import com.oliveira.starwars.entities.Film;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class FilmResponse {
    private String title;
    private String director;
    private String producer;

    public FilmResponse(Film film) {
        title = film.getTitle();
        director = film.getDirector();
        producer = film.getProducer();
    }
}