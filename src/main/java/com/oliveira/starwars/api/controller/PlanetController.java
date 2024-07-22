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

    @PostMapping
    public ResponseEntity<PlanetResponse> insert(@Valid @RequestBody PlanetRequest request) {
        PlanetResponse dto = service.insert(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }

    @GetMapping
    public ResponseEntity<List<PlanetResponse>> listPlanets() {
        List<PlanetResponse> dto = service.searchAll();
        return ResponseEntity.ok(dto);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PlanetResponse> findById(@PathVariable Long id) {
        PlanetResponse dto = service.findById(id);
        if (dto != null) {
            return ResponseEntity.ok(dto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping(value = "/{findByName}/findByName")
    public ResponseEntity<PlanetResponse> findByName(@PathVariable String name) {
        PlanetResponse dto = service.searchByName(name);
        if (dto != null) {
            return ResponseEntity.ok(dto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}