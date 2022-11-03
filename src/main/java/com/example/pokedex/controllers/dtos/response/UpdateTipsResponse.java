package com.example.pokedex.controllers.dtos.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateTipsResponse {
    private Long id;

    private String description;

    private String image;
}
