package com.example.pokedex.controllers.dtos.request;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CreateLeagueRequest {
    private String name;
    private String region;
    private String limitpokemon;
}
