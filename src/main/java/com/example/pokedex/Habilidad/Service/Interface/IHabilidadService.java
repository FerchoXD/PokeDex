package com.example.pokedex.Habilidad.Service.Interface;

import com.example.pokedex.Habilidad.controller.dtos.response.CreateHabilidadResponse;
import com.example.pokedex.Habilidad.controller.dtos.response.GetHabilidadResponse;
import com.example.pokedex.Habilidad.controller.dtos.response.UpdateHabilidadResponse;
import com.example.pokedex.Habilidad.controller.dtos.request.CreateHabilidadRequest;
import com.example.pokedex.Habilidad.controller.dtos.request.UpdateHabilidadRequest;

import java.util.List;

public interface IHabilidadService {
    GetHabilidadResponse get(Long id);

    CreateHabilidadResponse create(CreateHabilidadRequest request);

    UpdateHabilidadResponse update(UpdateHabilidadRequest request, Long id);

    List<GetHabilidadResponse> list();

    void delete(Long id);
}
