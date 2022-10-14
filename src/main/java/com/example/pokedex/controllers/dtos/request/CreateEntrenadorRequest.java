package com.example.pokedex.controllers.dtos.request;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CreateEntrenadorRequest {
    private String nombre;
    private String edad;
    private String nacionalidad;
}
