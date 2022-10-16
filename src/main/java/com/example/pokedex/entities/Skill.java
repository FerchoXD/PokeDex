package com.example.pokedex.entities;

import com.example.pokedex.pivots.PokemonsSkill;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table (name = "skills")
@Getter @Setter
public class Skill {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String effect;

    private String type;

    @OneToMany(mappedBy = "skill")
    private List<PokemonsSkill> pokemonsSkills;

}
