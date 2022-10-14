package com.example.pokedex.pivots;

import com.example.pokedex.entities.Habilidad;
import com.example.pokedex.entities.Pokemon;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "PokemonsHabilidad")
@Getter
@Setter
public class PokemonsHabilidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Pokemon pokemon;
    @ManyToOne
    private Habilidad habilidad;
}