package com.example.pokedex.controllers.dtos.request;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter @Setter
public class CreateSkillRequest {
    @NotBlank
    private String name;
    @NotBlank
    private String effect;
    @NotBlank
    private String type;
}
