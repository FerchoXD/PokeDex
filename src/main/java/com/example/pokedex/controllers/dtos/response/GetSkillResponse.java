package com.example.pokedex.controllers.dtos.response;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class GetSkillResponse {
    private Long id;

    private String name;

    private String effect;

    private String type;
}
