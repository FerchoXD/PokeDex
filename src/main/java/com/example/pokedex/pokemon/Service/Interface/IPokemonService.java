package com.example.pokedex.pokemones.Service.Interface;

import com.example.pokedex.pokemones.Controllers.dtos.request.CreatePokemonRequest;
import com.example.pokedex.pokemones.Controllers.dtos.request.UpdatePokemonRequest;
import com.example.pokedex.pokemones.Controllers.dtos.response.CreatePokemonResponse;
import com.example.pokedex.pokemones.Controllers.dtos.response.GetPokemonResponse;
import com.example.pokedex.pokemones.Controllers.dtos.response.UpdatePokemonResponse;

import java.util.List;

public interface IPokemonService {
    GetPokemonResponse get(Long id_Pokemon);

    CreatePokemonResponse create(CreatePokemonRequest request);

    UpdatePokemonResponse update(UpdatePokemonRequest request, Long id_Pokemon);

    List<GetPokemonResponse> list();

    void delete(Long id_pokemon);
}
