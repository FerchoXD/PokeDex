package com.example.pokedex.entities;

import com.example.pokedex.pivots.PokemonsSkill;
import com.example.pokedex.pivots.TrainersLeague;
import com.example.pokedex.pivots.TrainersPokemon;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table (name = "trainers")
@Getter @Setter
public class Trainer {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String age;

    private String nationality;

    @OneToMany(mappedBy = "trainer")
    private List<TrainersPokemon> trainersPokemon;

    @OneToMany(mappedBy = "trainer")
    private List<TrainersLeague> trainersLeagues;
}
