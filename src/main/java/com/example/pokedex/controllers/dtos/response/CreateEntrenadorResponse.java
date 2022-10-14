package com.example.pokedex.controllers.dtos.response;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CreateEntrenadorResponse {
    private Long id;
    private String nombre;
    private String edad;
    private String nacionalidad;
}
