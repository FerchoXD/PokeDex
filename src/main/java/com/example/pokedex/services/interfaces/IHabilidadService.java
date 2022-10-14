package com.example.pokedex.services.interfaces;

import com.example.pokedex.controllers.dtos.request.CreateHabilidadRequest;
import com.example.pokedex.controllers.dtos.request.UpdateHabilidadRequest;
import com.example.pokedex.controllers.dtos.response.CreateHabilidadResponse;
import com.example.pokedex.controllers.dtos.response.GetHabilidadResponse;
import com.example.pokedex.controllers.dtos.response.UpdateHabilidadResponse;

import java.util.List;

public interface IHabilidadService {
    GetHabilidadResponse get(Long id);

    CreateHabilidadResponse create(CreateHabilidadRequest request);

    UpdateHabilidadResponse update(UpdateHabilidadRequest request, Long id);

    List<GetHabilidadResponse> list();

    void delete(Long id);
}
