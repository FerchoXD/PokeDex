package com.example.pokedex.services;

import com.example.pokedex.controllers.dtos.request.CreatePokemonRequest;
import com.example.pokedex.controllers.dtos.request.UpdatePokemonRequest;
import com.example.pokedex.controllers.dtos.response.CreatePokemonResponse;
import com.example.pokedex.controllers.dtos.response.GetPokemonResponse;
import com.example.pokedex.controllers.dtos.response.UpdatePokemonResponse;
import com.example.pokedex.entities.Pokemon;
import com.example.pokedex.repositories.IPokemonRepository;
import com.example.pokedex.services.interfaces.IPokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PokemonServiceImpl implements IPokemonService {
    @Autowired
    private IPokemonRepository repository;


    @Override
    public GetPokemonResponse get(Long id) {
        Pokemon pokemon = find(id);
        return from(pokemon);
    }

    @Override
    public CreatePokemonResponse create(CreatePokemonRequest request) {
        Pokemon pokemon= new Pokemon();
        pokemon.setName(request.getName());
        pokemon.setSpecies(request.getSpecies());
        pokemon.setType(request.getType());
        pokemon.setColor(request.getColor());
        repository.save(pokemon);
        return to(pokemon);
    }

    @Override
    public UpdatePokemonResponse update(UpdatePokemonRequest request, Long id) {
        Pokemon pokemon = find(id);
        pokemon.setName(request.getName());
        pokemon.setSpecies(request.getSpecies());
        pokemon.setType(request.getType());
        pokemon.setColor(request.getColor());
        repository.save(pokemon);
        return fromUpdate(pokemon);
    }

    @Override
    public List<GetPokemonResponse> list() {
        return repository.findAll().stream().map(this::from).collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    public CreatePokemonResponse to(Pokemon pokemon) {
        CreatePokemonResponse response = new CreatePokemonResponse();
        response.setId(pokemon.getId());
        response.setName(pokemon.getName());
        response.setSpecies(pokemon.getSpecies());
        response.setType(pokemon.getType());
        response.setColor(pokemon.getColor());
        return response;
    }

    public GetPokemonResponse from(Pokemon pokemon) {
        GetPokemonResponse response = new GetPokemonResponse();
        response.setId(pokemon.getId());
        response.setType(pokemon.getType());
        response.setSpecies(pokemon.getSpecies());
        response.setName(pokemon.getName());
        response.setColor(pokemon.getColor());
        return response;
    }

    public UpdatePokemonResponse fromUpdate(Pokemon pokemon) {
        UpdatePokemonResponse response = new UpdatePokemonResponse();
        response.setId(pokemon.getId());
        response.setName(pokemon.getName());
        response.setType(pokemon.getType());
        response.setSpecies(pokemon.getSpecies());
        response.setColor(pokemon.getColor());
        return response;
    }
    public Pokemon find(Long id){
        return  repository.findById(id).orElseThrow(()->new RuntimeException("no se encpontro"));
    }
}
