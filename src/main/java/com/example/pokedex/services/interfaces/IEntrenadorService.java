package com.example.pokedex.services.interfaces;

import com.example.pokedex.controllers.dtos.request.CreateEntrenadorRequest;
import com.example.pokedex.controllers.dtos.request.UpdateEntrenadorRequest;
import com.example.pokedex.controllers.dtos.response.CreateEntrenadorResponse;
import com.example.pokedex.controllers.dtos.response.GetEntrenadorResponse;
import com.example.pokedex.controllers.dtos.response.UpdateEntrenadorResponse;

import java.util.List;

public interface IEntrenadorService {
    GetEntrenadorResponse get(Long id);

    CreateEntrenadorResponse create(CreateEntrenadorRequest request);

    UpdateEntrenadorResponse update(UpdateEntrenadorRequest request, Long id);

    List<GetEntrenadorResponse> list();

    void delete(Long id);
}
