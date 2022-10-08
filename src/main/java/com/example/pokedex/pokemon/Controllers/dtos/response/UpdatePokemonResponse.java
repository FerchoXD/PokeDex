package com.example.pokedex.pokemones.Controllers.dtos.response;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UpdatePokemonResponse {
    private Long id_Pokemon;
    private String nombre;
    private String Especie;
    private String Tipo;
    private String Color;
}
