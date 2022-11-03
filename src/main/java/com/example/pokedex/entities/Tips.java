package com.example.pokedex.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "tips")
@Getter
@Setter
public class Tips {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    private String image;

    @ManyToOne
    private Trainer trainer;
}
