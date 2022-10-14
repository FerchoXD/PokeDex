package com.example.pokedex.entities;

import com.example.pokedex.pivots.PokemonsHabilidad;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table (name = "pokemon")
@Getter @Setter
public class Pokemon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String especie;

    private String tipo;

    private String color;

    @OneToOne(mappedBy = "pokemon")
    @PrimaryKeyJoinColumn
    private Pokebola pokebola;

    @OneToMany(mappedBy = "pokemon")
    private List<PokemonsHabilidad> pokemonsHabilidades;

    @ManyToOne
    private Entrenador entrenadorOfPokemon;
}
