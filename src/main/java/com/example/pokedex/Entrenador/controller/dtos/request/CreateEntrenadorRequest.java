package com.example.pokedex.Entrenador.controller.dtos.request;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CreateEntrenadorRequest {
    private String nombre;
    private String edad;
    private String nacionalidad;
}
