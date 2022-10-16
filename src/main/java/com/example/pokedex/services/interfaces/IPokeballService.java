package com.example.pokedex.services.interfaces;

import com.example.pokedex.controllers.dtos.request.CreatePokeballRequest;
import com.example.pokedex.controllers.dtos.request.UpdatePokeballRequest;
import com.example.pokedex.controllers.dtos.response.CreatePokeballResponse;
import com.example.pokedex.controllers.dtos.response.GetPokeballResponse;
import com.example.pokedex.controllers.dtos.response.UpdatePokeballResponse;

import java.util.List;

public interface IPokeballService {
    GetPokeballResponse get(Long id);

    CreatePokeballResponse create(CreatePokeballRequest request);

    UpdatePokeballResponse update(UpdatePokeballRequest request, Long id);

    List<GetPokeballResponse> list();

    void delete(Long id);
}
