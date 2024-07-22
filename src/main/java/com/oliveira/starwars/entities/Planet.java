package com.oliveira.starwars.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Table(name = "tb_planet")
@Entity
public class Planet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String climate;
    private String terrain;
    private int quantityAppearancesInFilms;

    @ManyToMany
    @JoinTable(name = "tb_planet_film",
        joinColumns = @JoinColumn(name = "planet_id"),
        inverseJoinColumns = @JoinColumn(name = "film_id"))
    Set<Film> films = new HashSet<>();
}