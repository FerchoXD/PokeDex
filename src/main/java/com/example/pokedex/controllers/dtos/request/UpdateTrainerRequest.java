package com.example.pokedex.controllers.dtos.request;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UpdateTrainerRequest {
    private String name;

    private String password;

    private String age;

    private String category;

    private String image;
}

