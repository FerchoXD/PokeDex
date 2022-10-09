package com.example.pokedex.Liga.Controller.dtos.Response;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class GetLigaResponse {
    private Long id_Liga;
    private String nombre;
    private String region;
    private String limitepokemon;
}
