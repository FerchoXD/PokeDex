package com.example.pokedex.controllers;

import com.example.pokedex.controllers.dtos.request.CreatePokeballRequest;
import com.example.pokedex.controllers.dtos.request.UpdatePokeballRequest;
import com.example.pokedex.controllers.dtos.response.*;
import com.example.pokedex.services.PokeballServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("pokeball")
public class PokeballController {
    @Autowired
    private PokeballServiceImpl service;

    @GetMapping("{id}")
    public GetPokeballResponse get(@PathVariable Long id){
        return service.get(id);
    }

    @PostMapping
    public CreatePokeballResponse Create(@RequestBody CreatePokeballRequest request){
        return service.create(request);
    }

    @PutMapping("{id}")
    public UpdatePokeballResponse update(@RequestBody UpdatePokeballRequest request, @PathVariable Long id){
        return service.update(request, id);
    }

    @GetMapping
    public List<GetPokeballResponse> list(){
        return service.list();
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }

    @GetMapping("pokeballs/pokemon/{pokemonId}")
    public List<PokeballResponse> listAllTrainersByPokemonId(@PathVariable Long pokemonId) {
        return service.listAllTrainersByPokemonId(pokemonId);
    }
}
