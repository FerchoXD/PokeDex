package com.example.pokedex.controllers.dtos.request;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CreateSkillRequest {
    private String name;

    private String effect;

    private String type;
}
