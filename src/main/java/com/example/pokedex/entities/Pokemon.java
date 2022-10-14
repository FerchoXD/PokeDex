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
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String Especie;
    private String Tipo;
    private String Color;

    @OneToOne(mappedBy = "pokemon")
    @PrimaryKeyJoinColumn
    private Pokebola pokebola;

    @OneToMany(mappedBy = "pokemon")
    private List<PokemonsHabilidad> pokemonsHabilidades;

    @ManyToOne
    private Entrenador entrenador_of_pokemon;
}
