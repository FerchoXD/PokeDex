package com.example.pokedex.Entrenador.Entity;

import com.example.pokedex.Liga.Entity.Liga;
import com.example.pokedex.Pokebola.Entity.Pokebola;
import com.example.pokedex.pokemon.Entity.Pokemon;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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
