package com.example.pokedex.controllers.dtos.request;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UpdatePokeballRequest {
    private String name;

    private String level;

    private String recommendation;

    private String image;
}
