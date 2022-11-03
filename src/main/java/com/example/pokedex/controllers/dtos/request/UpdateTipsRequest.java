package com.example.pokedex.controllers.dtos.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateTipsRequest {
    private String description;

    private String image;
}
