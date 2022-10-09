package com.example.pokedex.pokemon.Controller.dtos.request;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UpdatePokemonRequest {
    private String nombre;
    private String Especie;
    private String Tipo;
    private String Color;
}
