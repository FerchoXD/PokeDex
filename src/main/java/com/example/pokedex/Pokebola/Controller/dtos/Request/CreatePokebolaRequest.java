package com.example.pokedex.Pokebola.Controller.dtos.Request;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CreatePokebolaRequest {
    private String nombre;
    private String nivel;
    private String color;
}
