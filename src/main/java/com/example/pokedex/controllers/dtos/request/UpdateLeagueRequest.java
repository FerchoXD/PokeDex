package com.example.pokedex.controllers.dtos.request;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UpdateLeagueRequest extends UpdateForumRequest {
    private String name;

    private String region;

    private String limitpokemon;

    private String image;
}
