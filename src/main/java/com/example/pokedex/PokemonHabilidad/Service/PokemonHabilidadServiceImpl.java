package com.example.pokedex.PokemonHabilidad.Service;

import com.example.pokedex.PokemonHabilidad.Controller.dto.Response.HabilidadResponse;
import com.example.pokedex.PokemonHabilidad.Controller.Projections.HabilidadProjections;
import com.example.pokedex.PokemonHabilidad.Repository.IPokemonHabilidadRepository;
import com.example.pokedex.PokemonHabilidad.Service.Interface.IPokemonHabilidadService;
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
