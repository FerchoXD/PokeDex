package com.example.pokedex.Pokebola.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Pokebola")
@Getter @Setter
public class Pokebola {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_Pokebola;
    private String nombre;
    private String nivel;
    private String color;
}

