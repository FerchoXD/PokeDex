package com.example.pokedex.Habilidad.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table (name = "Habilidad")
@Getter @Setter
public class Habilidad {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id_Habilidad;
    private String nombre;
    private String efecto;
    private String tipo;

}
