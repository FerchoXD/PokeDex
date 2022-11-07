package com.example.pokedex.controllers.dtos.response;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class LeagueResponse {
    private Long id;

    private String name ;

    private String region;

    private String image;

    private String trainersId;

    private String trainersName;
}
