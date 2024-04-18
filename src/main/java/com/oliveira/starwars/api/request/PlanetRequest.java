package com.oliveira.starwars.api.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record PlanetRequest(
        @NotNull @NotEmpty Long id,
        @NotBlank String name,
        @NotBlank String climate,
        @NotBlank String terrain) {
}