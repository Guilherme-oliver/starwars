package com.oliveira.starwars.repositories;

import com.oliveira.starwars.entities.Planet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlanetRepository extends JpaRepository<Planet, Long> {
    Optional<Planet> searchByName(String name);

    @Query(value = "SELECT obj FROM Planet obj JOIN FETCH obj.films")
    List<Planet> searchAll();
}