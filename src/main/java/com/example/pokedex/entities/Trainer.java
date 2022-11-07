package com.example.pokedex.entities;

import com.example.pokedex.entities.pivots.TrainersForum;
import com.example.pokedex.entities.pivots.TrainersLeague;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Table (name = "trainers")
@Getter @Setter
public class Trainer {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @PrimaryKeyJoinColumn
    private Long id;
    @NotBlank
    private String name;
    @NotBlank
    private String password;
    @NotBlank
    private String age;

    private String category;
    @NotBlank
    private String image;

    @OneToMany(mappedBy = "trainer")
    private List<TrainersLeague> trainersLeague;

    @OneToMany(mappedBy = "trainer")
    private List<TrainersForum> trainersForum;

    @OneToMany(mappedBy = "trainer")
    private List<Tips> tips;

    @OneToMany(mappedBy = "trainer")
    private List<Comment> comment;
}
