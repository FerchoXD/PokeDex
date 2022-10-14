package com.example.pokedex.controllers;

import com.example.pokedex.controllers.dtos.response.HabilidadResponse;
import com.example.pokedex.services.PokemonHabilidadServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("Pokemon_Habilidad")
public class PokemonHabilidadController {
    @Autowired
    private PokemonHabilidadServiceImpl service;

    @GetMapping("Pokemon/Habilidad/{pokemonId}")
    public List<HabilidadResponse> listAllHabilidadesByPokemonId(@PathVariable Long pokemonId){
        return service.listAllHabilidadesByPokemonId(pokemonId);
    }
}
