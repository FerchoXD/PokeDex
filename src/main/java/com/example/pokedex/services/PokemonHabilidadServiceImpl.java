package com.example.pokedex.services;

import com.example.pokedex.controllers.dtos.response.HabilidadResponse;
import com.example.pokedex.entities.Projections.HabilidadProjections;
import com.example.pokedex.repositories.IPokemonHabilidadRepository;
import com.example.pokedex.services.interfaces.IPokemonHabilidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PokemonHabilidadServiceImpl implements IPokemonHabilidadService {
    @Autowired
    private IPokemonHabilidadRepository repository;

    @Override
    public List<HabilidadResponse> listAllHabilidadesByPokemonId(Long pokemonId) {
        List<HabilidadProjections> habilidades = repository.listAllHabilidadesByPokemonId(pokemonId);
        return habilidades.stream().map(this::from).collect(Collectors.toList());
    }

    private HabilidadResponse from (HabilidadProjections habilidad){
        HabilidadResponse response = new HabilidadResponse();
        response.setId(habilidad.getId());
        response.setNombre(habilidad.getNombre());
        response.setEfecto(habilidad.getEfecto());
        response.setTipo(habilidad.getTipo());
        return response;
    }
}
