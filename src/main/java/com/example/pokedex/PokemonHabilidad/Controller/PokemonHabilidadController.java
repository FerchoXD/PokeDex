package com.example.pokedex.PokemonHabilidad.Controller;

import com.example.pokedex.PokemonHabilidad.Controller.Projections.HabilidadProjections;
import com.example.pokedex.PokemonHabilidad.Controller.dto.Response.HabilidadResponse;
import com.example.pokedex.PokemonHabilidad.Service.PokemonHabilidadServiceImpl;
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
