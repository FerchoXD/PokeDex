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

    @OneToMany(mappedBy = "entrenadorOfPokeball")
    private List<Pokebola> pokebolas;

    @OneToMany(mappedBy = "entrenadorOfPokemon")
    private List<Pokemon> pokemons;

    @ManyToOne
    private Liga liga;
}
