package com.example.pokedex.pokemones.Controllers.dtos.request;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UpdatePokemonRequest {
    private String nombre;
    private String Especie;
    private String Tipo;
    private String Color;
}
