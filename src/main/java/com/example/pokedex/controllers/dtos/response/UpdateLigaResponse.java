package com.example.pokedex.controllers.dtos.response;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UpdateLigaResponse {
    private Long id;
    private String nombre;
    private String region;
    private String limitepokemon;
}
