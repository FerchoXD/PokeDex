package com.example.pokedex.controllers.dtos.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter @Setter
public class CreatePokeballRequest {
    @NotBlank
    private String name;

    private String level;

    private String recommendation;

    private String image;
}
