package com.example.pokedex.controllers.dtos.response;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CreatePokebolaResponse {
    private Long id;
    private String nombre;
    private String nivel;
    private String color;
}