package com.example.pokedex.controllers.dtos.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateCommentResponse {
    private Long id;

    private String title;

    private String description;

    private String hour;
}