package com.oliveira.starwars.api.controller;

import com.oliveira.starwars.api.request.PlanetRequest;
import com.oliveira.starwars.api.response.PlanetResponse;
import com.oliveira.starwars.services.PlanetService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/planetas")
public class PlanetController {

    private PlanetService service;

    public PlanetController(PlanetService service) {
        this.service = service;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PlanetResponse> findById(@PathVariable Long id) {
        PlanetResponse dto = service.findById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping(value = "/{findByName}/find-by-name")
    public ResponseEntity<PlanetResponse> findByName(@PathVariable String name) {
        PlanetResponse dto = service.searchByName(name);
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<List<PlanetResponse>> findByName() {
        List<PlanetResponse> dto = service.searchAll();
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<PlanetResponse> insert(@Valid @RequestBody PlanetRequest request) {
        var dto = service.insert(request);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }
}