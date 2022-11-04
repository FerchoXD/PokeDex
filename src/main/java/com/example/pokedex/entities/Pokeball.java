package com.example.pokedex.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "pokeballs")
@Getter @Setter
public class Pokeball {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String level;

    private String recommendation;

    private String image;

    @OneToOne
    private Pokemon pokemon;
}

