package com.example.pokedex.services.interfaces;

import com.example.pokedex.controllers.dtos.response.SkillResponse;

import java.util.List;

public interface IPokemonSkillService {
    List<SkillResponse> listAllSkillsByPokemonId(Long pokemonId);
}
