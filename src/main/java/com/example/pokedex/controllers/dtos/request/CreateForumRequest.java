package com.example.pokedex.controllers.dtos.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Time;
import java.util.Date;

@Getter
@Setter
public class CreateForumRequest {

    @NotNull @NotBlank
    private String topic;
    @NotBlank
    private Date date;
    @NotBlank
    private Time hour;

}
