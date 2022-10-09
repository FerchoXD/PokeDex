package com.example.pokedex.pokemon.Controller;

import com.example.pokedex.pokemon.Controller.dtos.request.CreatePokemonRequest;
import com.example.pokedex.pokemon.Controller.dtos.request.UpdatePokemonRequest;
import com.example.pokedex.pokemon.Controller.dtos.response.CreatePokemonResponse;
import com.example.pokedex.pokemon.Controller.dtos.response.GetPokemonResponse;
import com.example.pokedex.pokemon.Controller.dtos.response.UpdatePokemonResponse;
import com.example.pokedex.pokemon.Service.ServicePokemonImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("pokemon")
public class PokemonController {
    @Autowired
    private ServicePokemonImpl service;
    @GetMapping("{id_Pokemon}")
    public GetPokemonResponse get(@PathVariable Long id_Pokemon){
        return service.get(id_Pokemon);
    }

    @PostMapping
    public CreatePokemonResponse Create(@RequestBody CreatePokemonRequest request){
        return service.create(request);
    }

    @PutMapping("{id_Pokemon}")
    public UpdatePokemonResponse update(@RequestBody UpdatePokemonRequest request,@PathVariable Long id_Pokemon){
        return service.update(request,id_Pokemon);
    }

    @GetMapping
    public List<GetPokemonResponse> list(){
        return service.list();
    }

    @DeleteMapping("{id_Pokemon}")
    public void delete(@PathVariable Long id_Pokemon){
        service.delete(id_Pokemon);
    }
}
