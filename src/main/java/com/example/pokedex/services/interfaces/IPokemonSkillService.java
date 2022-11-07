package com.example.pokedex.services.interfaces;

import com.example.pokedex.controllers.dtos.response.BaseResponse;
import com.example.pokedex.controllers.dtos.response.PokemonResponse;
import com.example.pokedex.controllers.dtos.response.SkillResponse;

import java.util.List;

public interface IPokemonSkillService {
    BaseResponse listAllSkillsByPokemonId(Long pokemonId);
    BaseResponse listAllPokemonBySkillsId(Long skillId);
}
