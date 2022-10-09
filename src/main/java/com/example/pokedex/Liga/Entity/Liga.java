package com.example.pokedex.Liga.Entity;

import com.example.pokedex.Entrenador.Entity.Entrenador;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Liga")
@Getter @Setter
public class Liga {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String region;
    private String limitepokemon;

    @OneToMany(mappedBy = "liga_of_entrenadores")
    private List<Entrenador> entrenadores;
}

