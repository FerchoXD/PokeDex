package com.example.pokedex.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Liga")
@Getter @Setter
public class Liga {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String region;

    private String limitePokemon;

    @OneToMany(mappedBy = "liga")
    private List<Entrenador> entrenadores;
}

