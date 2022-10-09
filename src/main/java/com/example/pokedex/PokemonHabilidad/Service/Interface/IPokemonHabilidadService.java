package com.example.pokedex.PokemonHabilidad.Service.Interface;

import com.example.pokedex.PokemonHabilidad.Controller.dto.Response.HabilidadResponse;

import java.util.List;

public interface IPokemonHabilidadService {
    List<HabilidadResponse> listAllHabilidadesByPokemonId(Long pokemonId);
}
