package com.example.pokedex.Liga.Controller.dtos.Response;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UpdateLigaResponse {
    private Long id;
    private String nombre;
    private String region;
    private String limitepokemon;
}
