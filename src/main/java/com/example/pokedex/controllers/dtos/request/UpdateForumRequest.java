package com.example.pokedex.controllers.dtos.request;

import lombok.Getter;
import lombok.Setter;

import java.sql.Time;
import java.util.Date;

@Getter
@Setter
public class UpdateForumRequest {
    private String topic;

    private Date date;

    private Time hour;

}
