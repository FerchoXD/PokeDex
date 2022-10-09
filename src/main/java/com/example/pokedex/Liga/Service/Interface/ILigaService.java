package com.example.pokedex.Liga.Service.Interface;

import com.example.pokedex.Liga.Controller.dtos.Request.CreateLigaRequest;
import com.example.pokedex.Liga.Controller.dtos.Request.UpdateLigaRequest;
import com.example.pokedex.Liga.Controller.dtos.Response.CreateLigaResponse;
import com.example.pokedex.Liga.Controller.dtos.Response.GetLigaResponse;
import com.example.pokedex.Liga.Controller.dtos.Response.UpdateLigaResponse;

import java.util.List;

public interface ILigaService {
    GetLigaResponse get(Long id_liga);

    CreateLigaResponse create(CreateLigaRequest request);

    UpdateLigaResponse update(UpdateLigaRequest request, Long id_liga);

    List<GetLigaResponse> list();

    void delete(Long id_liga);
}
