package com.example.pokedex.controllers.dtos.request;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UpdateHabilidadRequest {
    private String nombre;
    private String efecto;
    private String tipo;
}