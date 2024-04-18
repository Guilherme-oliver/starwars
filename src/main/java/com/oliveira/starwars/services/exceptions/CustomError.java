package com.oliveira.starwars.services.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.Instant;

@AllArgsConstructor
@Getter
public class CustomError {
    private Instant timeStamp;
    private Integer status;
    private String error;
    private String path;
}