package com.example.pokedex.Pokebola.Entity;

import com.example.pokedex.Entrenador.Entity.Entrenador;
import com.example.pokedex.pokemon.Entity.Pokemon;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Pokebola")
@Getter @Setter
public class Pokebola {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pokebola_id")
    private Long id;
    private String nombre;
    private String nivel;
    private String color;

    @OneToOne
    @MapsId
    @JoinColumn(name = "pokebola_id")
    private Pokemon pokemon;

    @ManyToOne
    private Entrenador entrenador_of_pokeball;
}

