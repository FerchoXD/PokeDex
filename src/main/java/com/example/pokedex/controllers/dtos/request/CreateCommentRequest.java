package com.example.pokedex.controllers.dtos.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.sql.Time;

@Getter
@Setter
public class CreateCommentRequest {
    @NotBlank
    private String title;
    @NotBlank
    private String description;
    @NotBlank
    private Time hour;
}
