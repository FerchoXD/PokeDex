package com.example.pokedex.controllers.dtos.response;

import lombok.Getter;
import lombok.Setter;

import java.sql.Time;

@Getter
@Setter
public class CreateCommentResponse {
    private Long id;

    private String title;

    private String description;

    private Time hour;
}
