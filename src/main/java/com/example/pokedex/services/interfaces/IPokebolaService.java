package com.example.pokedex.services.interfaces;

import com.example.pokedex.controllers.dtos.request.CreatePokebolaRequest;
import com.example.pokedex.controllers.dtos.request.UpdatePokebolaRequest;
import com.example.pokedex.controllers.dtos.response.CreatePokebolaResponse;
import com.example.pokedex.controllers.dtos.response.GetPokebolaResponse;
import com.example.pokedex.controllers.dtos.response.UpdatePokebolaResponse;

import java.util.List;

public interface IPokebolaService {
    GetPokebolaResponse get(Long id);

    CreatePokebolaResponse create(CreatePokebolaRequest request);

    UpdatePokebolaResponse update(UpdatePokebolaRequest request, Long id);

    List<GetPokebolaResponse> list();

    void delete(Long id);
}
