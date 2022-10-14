package com.example.pokedex.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table (name = "Entrenador")
@Getter @Setter
public class Entrenador {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String edad;
    private String nacionalidad;

    @OneToMany(mappedBy = "entrenador_of_pokeball")
    private List<Pokebola> pokebolas;

    @OneToMany(mappedBy = "entrenador_of_pokemon")
    private List<Pokemon> pokemons;

    @ManyToOne
    private Liga liga_of_entrenadores;
}
