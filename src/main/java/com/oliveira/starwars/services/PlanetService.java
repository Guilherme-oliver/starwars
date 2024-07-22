package com.oliveira.starwars.services;

import com.oliveira.starwars.api.request.PlanetRequest;
import com.oliveira.starwars.api.response.PlanetResponse;
import com.oliveira.starwars.entities.Planet;
import com.oliveira.starwars.repositories.PlanetRepository;
import com.oliveira.starwars.services.exceptions.DatabaseException;
import com.oliveira.starwars.services.exceptions.ResourceNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PlanetService {

    private PlanetRepository planetRepository;

    private SwapiService swapiService;

    public PlanetService(PlanetRepository planetRepository, SwapiService swapiService) {
        this.planetRepository = planetRepository;
        this.swapiService = swapiService;
    }

    public PlanetResponse findById(Long id) {
        Planet planet = planetRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Resource not found!"));
        return new PlanetResponse(planet);
    }

    public PlanetResponse searchByName(String name) {
        Planet planet = planetRepository.searchByName(name).orElseThrow(
                () -> new ResourceNotFoundException("Resource not found!"));
        return new PlanetResponse(planet);
    }

    public List<PlanetResponse> searchAll() {
        List<Planet> result = planetRepository.searchAll();
        return result.stream().map(PlanetResponse::new).toList();
    }

    private void copyDtoToEntity(PlanetRequest request, Planet entity) {
        entity.setName(request.name());
        entity.setClimate(request.climate());
        entity.setTerrain(request.terrain());
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public PlanetResponse insert(PlanetRequest request) {
        Planet entity = new Planet();
        copyDtoToEntity(request, entity);
        PlanetResponse planetDto = swapiService.getPlanetByName(entity.getName());
        if (planetDto != null) {
            entity.setClimate(planetDto.getClimate());
            entity.setTerrain(planetDto.getTerrain());
            entity.setQuantityAppearancesInFilms(planetDto.getFilms().size());
        }
        Planet savedPlanet = planetRepository.save(entity);
        return new PlanetResponse(savedPlanet);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Long id) {
        if (!planetRepository.existsById(id)) {
            throw new ResourceNotFoundException("Resource not found!");
        }
        try {
            planetRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Referential integrity failure!");
        }
    }
}