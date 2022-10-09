package com.example.pokedex.Liga.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Liga")
@Getter @Setter
public class Liga {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_Liga;
    private String nombre;
    private String region;
    private String limitepokemon;
}

