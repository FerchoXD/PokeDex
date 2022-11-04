package com.example.pokedex.controllers.dtos.response;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CreatePokemonResponse {
    private Long id;

    private String name;

    private String species;

    private String type;

    private String image;
}
