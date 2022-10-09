package com.example.pokedex.Liga.Controller.dtos.Request;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CreateLigaRequest {
    private String nombre;
    private String region;
    private String limitepokemon;
}
