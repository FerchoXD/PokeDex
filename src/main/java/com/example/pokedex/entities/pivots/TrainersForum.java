package com.example.pokedex.entities.pivots;

import com.example.pokedex.entities.Forum;
import com.example.pokedex.entities.Trainer;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "trainerForum")
@Getter
@Setter
public class TrainersForum {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Forum forum;

    @ManyToOne
    private Trainer trainer;
}
