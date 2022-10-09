package com.example.pokedex.Entrenador.controller.dtos.request;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UpdateEntrenadorRequest {
    private String nombre;
    private String edad;
    private String nacionalidad;
}
