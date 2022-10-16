package com.example.pokedex.controllers.dtos.request;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CreateTrainerRequest {
    private String name;

    private String age;

    private String nationality;
}
