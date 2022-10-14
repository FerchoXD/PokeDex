package com.example.pokedex.controllers.dtos.request;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CreatePokemonRequest {
    private String nombre;
    private String Especie;
    private String Tipo;
    private String Color;
}
