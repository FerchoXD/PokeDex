package com.example.pokedex.controllers.dtos.request;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter @Setter
public class CreateTrainerRequest {

    @NotBlank
    private String name;
    @NotBlank
    private String password;
    @NotBlank
    private String age;

    private String category;

    private String image;
}
