package com.example.pokedex.Pokebola.Service.Interface;

import com.example.pokedex.Pokebola.Controller.dtos.Request.CreatePokebolaRequest;
import com.example.pokedex.Pokebola.Controller.dtos.Request.UpdatePokebolaRequest;
import com.example.pokedex.Pokebola.Controller.dtos.Response.CreatePokebolaResponse;
import com.example.pokedex.Pokebola.Controller.dtos.Response.GetPokebolaResponse;
import com.example.pokedex.Pokebola.Controller.dtos.Response.UpdatePokebolaResponse;

import java.util.List;

public interface IPokebolaService {
    GetPokebolaResponse get(Long id);

    CreatePokebolaResponse create(CreatePokebolaRequest request);

    UpdatePokebolaResponse update(UpdatePokebolaRequest request, Long id);

    List<GetPokebolaResponse> list();

    void delete(Long id);
}
