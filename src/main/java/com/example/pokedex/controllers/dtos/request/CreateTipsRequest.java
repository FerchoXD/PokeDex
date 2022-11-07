package com.example.pokedex.controllers.dtos.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class CreateTipsRequest {
    @NotBlank
    private String description;
    @NotBlank
    private String image;
}
