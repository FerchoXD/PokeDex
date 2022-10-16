package com.example.pokedex.services;

import com.example.pokedex.controllers.dtos.response.PokemonResponse;
import com.example.pokedex.controllers.dtos.response.SkillResponse;
import com.example.pokedex.entities.Projections.PokemonProjections;
import com.example.pokedex.entities.Projections.SkillProjections;
import com.example.pokedex.repositories.IPokemonSkillRepository;
import com.example.pokedex.services.interfaces.IPokemonSkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PokemonSkillServiceImpl implements IPokemonSkillService {
    @Autowired
    private IPokemonSkillRepository repository;

    @Override
    public List<SkillResponse> listAllSkillsByPokemonId(Long pokemonId) {
        List<SkillProjections> skills = repository.listAllSkillsByPokemonId(pokemonId);
        return skills.stream().map(this::from).collect(Collectors.toList());
    }

    public List<PokemonResponse> listAllPokemonBySkillsId(Long skillId) {
        List<PokemonProjections> pokemons = repository.listAllPokemonBySkillsId(skillId);
        return pokemons.stream().map(this::from).collect(Collectors.toList());
    }

    private SkillResponse from (SkillProjections skills){
        SkillResponse response = new SkillResponse();
        response.setId(skills.getId());
        response.setName(skills.getName());
        response.setEffect(skills.getEffect());
        response.setType(skills.getType());
        response.setPokemonName(skills.getPokemonName());
        return response;
    }

    private PokemonResponse from (PokemonProjections pokemons){
        PokemonResponse response = new PokemonResponse();
        response.setId(pokemons.getId());
        response.setName(pokemons.getName());
        response.setSpecies(pokemons.getSpecies());
        response.setColor(pokemons.getColor());
        response.setType(pokemons.getType());
        return response;
    }
}
