package com.example.pokedex.controllers.dtos.request;

import lombok.Getter;
import lombok.Setter;

import java.sql.Time;

@Getter
@Setter
public class UpdateCommentRequest {

    private String title;

    private String description;

    private Time hour;
}
