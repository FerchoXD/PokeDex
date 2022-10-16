package com.example.pokedex.controllers.dtos.request;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UpdatePokemonRequest {
    private String name;

    private String species;

    private String type;

    private String Color;

}
