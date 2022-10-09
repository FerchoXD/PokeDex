package com.example.pokedex.pivots;

import com.example.pokedex.Habilidad.Entity.Habilidad;
import com.example.pokedex.pokemon.Entity.Pokemon;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Pokemons_Habilidades")
@Getter
@Setter
public class PokemonsHabilidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Pokemon pokemon;
    @ManyToOne
    private Habilidad habilidad;
}