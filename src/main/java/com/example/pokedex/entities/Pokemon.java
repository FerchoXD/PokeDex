package com.example.pokedex.entities;

import com.example.pokedex.pivots.PokemonsSkill;
import com.example.pokedex.pivots.TrainersPokemon;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table (name = "pokemons")
@Getter @Setter
public class Pokemon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String species;

    private String type;

    private String color;

    @OneToOne(mappedBy = "pokemon")
    @PrimaryKeyJoinColumn
    private Pokeball pokeball;

    @OneToMany(mappedBy = "pokemon")
    private List<PokemonsSkill> pokemonsSkills;

    @OneToMany(mappedBy = "pokemon")
    private List<TrainersPokemon> trainersPokemon;
}
