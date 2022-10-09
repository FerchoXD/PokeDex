package com.example.pokedex.Habilidad.controller.dtos.request;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UpdateHabilidadRequest {
    private String nombre;
    private String efecto;
    private String tipo;
}
