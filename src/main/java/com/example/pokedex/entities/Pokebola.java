package com.example.pokedex.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Pokebola")
@Getter @Setter
public class Pokebola {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String nivel;

    private String color;

    @OneToOne
    @MapsId
    @JoinColumn(name = "pokebola_id")
    private Pokemon pokemon;

    @ManyToOne
    private Entrenador entrenadorOfPokeball;
}

