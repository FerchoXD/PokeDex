package com.example.pokedex.Habilidad.Entity;

import com.example.pokedex.pivots.PokemonsHabilidad;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table (name = "Habilidad")
@Getter @Setter
public class Habilidad {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String efecto;
    private String tipo;

    @OneToMany(mappedBy = "habilidad")
    private List<PokemonsHabilidad> pokemonsHabilidades;

}
