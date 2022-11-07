package com.example.pokedex.services;

import com.example.pokedex.controllers.dtos.response.BaseResponse;
import com.example.pokedex.controllers.dtos.response.PokemonResponse;
import com.example.pokedex.controllers.dtos.response.SkillResponse;
import com.example.pokedex.entities.projections.PokemonProjections;
import com.example.pokedex.entities.projections.SkillProjections;
import com.example.pokedex.repositories.IPokemonSkillRepository;
import com.example.pokedex.services.interfaces.IPokemonSkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PokemonSkillServiceImpl implements IPokemonSkillService {
    @Autowired
    private IPokemonSkillRepository repository;

    @Override
    public BaseResponse listAllSkillsByPokemonId(Long pokemonId) {
        List<SkillProjections> skills = repository.listAllSkillsByPokemonId(pokemonId);
        List<SkillResponse> response = skills.stream()
                .map(this::from)
                .collect(Collectors.toList());

        return BaseResponse.builder()
                .data(response)
                .message("Skills list by pokemon Id")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.OK).build();
    }

    public BaseResponse listAllPokemonBySkillsId(Long skillId) {
        List<PokemonProjections> pokemons = repository.listAllPokemonBySkillsId(skillId);
        List<PokemonResponse> response = pokemons.stream().map(this::from).collect(Collectors.toList());
        return BaseResponse.builder()
                .data(response)
                .message("Pokemons list by skill Id")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.OK).build();
    }

    private SkillResponse from (SkillProjections skills){
        SkillResponse response = new SkillResponse();
        response.setId(skills.getId());
        response.setName(skills.getName());
        response.setEffect(skills.getEffect());
        response.setType(skills.getType());
        response.setPokemonsName(skills.getPokemonsName());
        return response;
    }

    private PokemonResponse from (PokemonProjections pokemons){
        PokemonResponse response = new PokemonResponse();
        response.setId(pokemons.getId());
        response.setName(pokemons.getName());
        response.setSpecies(pokemons.getSpecies());
        response.setType(pokemons.getType());
        response.setImage(pokemons.getImage());
        return response;
    }
}
