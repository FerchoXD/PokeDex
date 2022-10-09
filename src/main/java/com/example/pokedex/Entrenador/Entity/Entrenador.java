package com.example.pokedex.Entrenador.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table (name = "Entrenador")
@Getter @Setter
public class Entrenador {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id_Entrenador;
    private String nombre;
    private String edad;
    private String nacionalidad;

}
