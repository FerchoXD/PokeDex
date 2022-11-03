package com.example.pokedex.controllers.dtos.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetForumResponse {
    private Long id;

    private String topic;

    private String date;

    private String hour;

    private String category;
}
