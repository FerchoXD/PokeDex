package com.example.pokedex.controllers.dtos.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TrainerForumResponse {
    private Long id;

    private String name;

    private String age;

    private String category;

    private String image;

    private String forumsTopic;

    private String forumsId;
}
