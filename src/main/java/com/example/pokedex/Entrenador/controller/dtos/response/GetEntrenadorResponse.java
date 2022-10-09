package com.example.pokedex.Entrenador.controller.dtos.response;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class GetEntrenadorResponse {
    private Long id_Entrenador;
    private String nombre;
    private String edad;
    private String nacionalidad;
}
