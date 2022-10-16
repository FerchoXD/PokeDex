package com.example.pokedex.entities.pivots;

import com.example.pokedex.entities.League;
import com.example.pokedex.entities.Trainer;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "trainerLeague")
@Getter
@Setter
public class TrainersLeague {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Trainer trainer;

    @ManyToOne
    private League league;
}
