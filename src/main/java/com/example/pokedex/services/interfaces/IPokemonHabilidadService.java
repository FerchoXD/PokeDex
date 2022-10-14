package com.example.pokedex.services.interfaces;

import com.example.pokedex.controllers.dtos.response.HabilidadResponse;

import java.util.List;

public interface IPokemonHabilidadService {
    List<HabilidadResponse> listAllHabilidadesByPokemonId(Long pokemonId);
}
