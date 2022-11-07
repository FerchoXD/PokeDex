package com.example.pokedex.controllers.dtos.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter @Setter
public class CreateLeagueRequest {
    @NotBlank
    private String name;
    @NotBlank
    private String region;

    private String image;
}
