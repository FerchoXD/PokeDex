package com.example.pokedex.controllers.dtos.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateTipsRequest {
    private String description;

    private String image;
}
