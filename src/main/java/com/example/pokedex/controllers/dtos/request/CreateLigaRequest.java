package com.example.pokedex.controllers.dtos.request;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CreateLigaRequest {
    private String nombre;
    private String region;
    private String limitepokemon;
}
