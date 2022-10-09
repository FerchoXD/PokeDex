package com.example.pokedex.pokemon.Service.Interface;

import com.example.pokedex.pokemon.Controller.dtos.request.CreatePokemonRequest;
import com.example.pokedex.pokemon.Controller.dtos.request.UpdatePokemonRequest;
import com.example.pokedex.pokemon.Controller.dtos.response.CreatePokemonResponse;
import com.example.pokedex.pokemon.Controller.dtos.response.GetPokemonResponse;
import com.example.pokedex.pokemon.Controller.dtos.response.UpdatePokemonResponse;

import java.util.List;

public interface IPokemonService {
    GetPokemonResponse get(Long id_Pokemon);

    CreatePokemonResponse create(CreatePokemonRequest request);

    UpdatePokemonResponse update(UpdatePokemonRequest request, Long id_Pokemon);

    List<GetPokemonResponse> list();

    void delete(Long id_pokemon);
}
