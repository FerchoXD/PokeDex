package com.example.pokedex.controllers.dtos.response;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UpdatePokemonResponse {
    private Long id;
    private String nombre;
    private String Especie;
    private String Tipo;
    private String Color;
}
