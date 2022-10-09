package com.example.pokedex.pokemon.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table (name = "pokemon")
@Getter @Setter
public class Pokemon {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id_Pokemon;
    private String nombre;
    private String Especie;
    private String Tipo;
    private String Color;


}
