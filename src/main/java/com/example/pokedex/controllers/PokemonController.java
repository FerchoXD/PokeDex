package com.example.pokedex.controllers;

import com.example.pokedex.controllers.dtos.request.CreatePokemonRequest;
import com.example.pokedex.controllers.dtos.request.UpdatePokemonRequest;
import com.example.pokedex.controllers.dtos.response.CreatePokemonResponse;
import com.example.pokedex.controllers.dtos.response.GetPokemonResponse;
import com.example.pokedex.controllers.dtos.response.UpdatePokemonResponse;
import com.example.pokedex.services.PokemonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("pokemon")
public class PokemonController {
    @Autowired
    private PokemonServiceImpl service;
    @GetMapping("{id}")
    public GetPokemonResponse get(@PathVariable Long id){
        return service.get(id);
    }

    @PostMapping
    public CreatePokemonResponse Create(@RequestBody CreatePokemonRequest request){
        return service.create(request);
    }

    @PutMapping("{id}")
    public UpdatePokemonResponse update(@RequestBody UpdatePokemonRequest request,@PathVariable Long id){
        return service.update(request, id);
    }

    @GetMapping
    public List<GetPokemonResponse> list(){
        return service.list();
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }
}
