package com.example.pokedex.services.interfaces;

import com.example.pokedex.controllers.dtos.request.CreateLigaRequest;
import com.example.pokedex.controllers.dtos.request.UpdateLigaRequest;
import com.example.pokedex.controllers.dtos.response.CreateLigaResponse;
import com.example.pokedex.controllers.dtos.response.GetLigaResponse;
import com.example.pokedex.controllers.dtos.response.UpdateLigaResponse;

import java.util.List;

public interface ILigaService {
    GetLigaResponse get(Long id);

    CreateLigaResponse create(CreateLigaRequest request);

    UpdateLigaResponse update(UpdateLigaRequest request, Long id);

    List<GetLigaResponse> list();

    void delete(Long id);
}
