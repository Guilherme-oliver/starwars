package com.oliveira.starwars.api.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record FilmRequest(
        @NotNull @NotEmpty Long id,
        @NotBlank String title,
        @NotBlank String director,
        @NotBlank String producer) {
}