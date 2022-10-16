package com.example.pokedex.services;

import com.example.pokedex.controllers.dtos.response.SkillResponse;
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
        List<SkillProjections> habilidades = repository.listAllSkillsByPokemonId(pokemonId);
        return habilidades.stream().map(this::from).collect(Collectors.toList());
    }

    private SkillResponse from (SkillProjections habilidad){
        SkillResponse response = new SkillResponse();
        response.setId(habilidad.getId());
        response.setName(habilidad.getName());
        response.setEffect(habilidad.getEffect());
        response.setType(habilidad.getType());
        return response;
    }
}
