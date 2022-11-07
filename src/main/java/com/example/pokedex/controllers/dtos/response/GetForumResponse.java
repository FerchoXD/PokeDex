package com.example.pokedex.controllers.dtos.response;

import lombok.Getter;
import lombok.Setter;

import java.sql.Time;
import java.util.Date;

@Getter
@Setter
public class GetForumResponse {
    private Long id;

    private String topic;

    private Date date;

    private Time hour;
}
