package com.example.pokedex.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "tips")
@Getter
@Setter
public class Tips {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String description;
    @NotBlank
    private String image;

    @ManyToOne
    private Trainer trainer;
}
