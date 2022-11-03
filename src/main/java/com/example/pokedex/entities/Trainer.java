package com.example.pokedex.entities;

import com.example.pokedex.entities.pivots.TrainersForum;
import com.example.pokedex.entities.pivots.TrainersLeague;
import com.example.pokedex.entities.pivots.TrainersPokemon;
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

    private String category;

    private String profilePicture;

    @OneToMany(mappedBy = "trainer")
    private List<TrainersPokemon> trainersPokemon;

    @OneToMany(mappedBy = "trainer")
    private List<TrainersLeague> trainersLeague;

    @OneToMany(mappedBy = "trainer")
    private List<TrainersForum> trainersForum;

    @OneToMany(mappedBy = "trainer")
    private List<Tips> tips;

    @OneToMany(mappedBy = "trainer")
    private List<Comment> comment;
}
