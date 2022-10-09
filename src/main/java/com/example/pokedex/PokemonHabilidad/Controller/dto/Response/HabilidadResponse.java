package com.example.pokedex.PokemonHabilidad.Controller.dto.Response;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class HabilidadResponse {
    private Long id;
    private String nombre;
    private String efecto;
    private String tipo;
}
