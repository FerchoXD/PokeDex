package com.example.pokedex.Entrenador.Service.Interface;

import com.example.pokedex.Entrenador.controller.dtos.request.CreateEntrenadorRequest;
import com.example.pokedex.Entrenador.controller.dtos.request.UpdateEntrenadorRequest;
import com.example.pokedex.Entrenador.controller.dtos.response.CreateEntrenadorResponse;
import com.example.pokedex.Entrenador.controller.dtos.response.GetEntrenadorResponse;
import com.example.pokedex.Entrenador.controller.dtos.response.UpdateEntrenadorResponse;

import java.util.List;

public interface IEntrenadorService {
    GetEntrenadorResponse get(Long id_Entrenador);

    CreateEntrenadorResponse create(CreateEntrenadorRequest request);

    UpdateEntrenadorResponse update(UpdateEntrenadorRequest request, Long id_Entrenador);

    List<GetEntrenadorResponse> list();

    void delete(Long id_Entrenador);
}
