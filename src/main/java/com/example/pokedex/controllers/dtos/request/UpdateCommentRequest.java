package com.example.pokedex.controllers.dtos.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateCommentRequest {

    private String title;

    private String description;

    private String hour;
}
