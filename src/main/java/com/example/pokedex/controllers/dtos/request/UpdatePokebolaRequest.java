package com.example.pokedex.controllers.dtos.request;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UpdatePokebolaRequest {
    private String nombre;
    private String nivel;
    private String color;
}
