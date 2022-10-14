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
public class ServicePokemonImpl implements IPokemonService {
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
        pokemon.setNombre(request.getNombre());
        pokemon.setEspecie(request.getEspecie());
        pokemon.setTipo(request.getTipo());
        pokemon.setColor(request.getColor());
        repository.save(pokemon);
        return to(pokemon);
    }

    @Override
    public UpdatePokemonResponse update(UpdatePokemonRequest request, Long id) {
        Pokemon pokemon = find(id);
        pokemon.setNombre(request.getNombre());
        pokemon.setEspecie(request.getEspecie());
        pokemon.setTipo(request.getTipo());
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
        response.setNombre(pokemon.getNombre());
        response.setEspecie(pokemon.getEspecie());
        response.setTipo(pokemon.getTipo());
        response.setColor(pokemon.getColor());
        return response;
    }

    public GetPokemonResponse from(Pokemon pokemon) {
        GetPokemonResponse response = new GetPokemonResponse();
        response.setId(pokemon.getId());
        response.setTipo(pokemon.getTipo());
        response.setEspecie(pokemon.getEspecie());
        response.setNombre(pokemon.getNombre());
        response.setColor(pokemon.getColor());
        return response;
    }

    public UpdatePokemonResponse fromUpdate(Pokemon pokemon) {
        UpdatePokemonResponse response = new UpdatePokemonResponse();
        response.setId(pokemon.getId());
        response.setNombre(pokemon.getNombre());
        response.setTipo(pokemon.getTipo());
        response.setEspecie(pokemon.getEspecie());
        response.setColor(pokemon.getColor());
        return response;
    }
    public Pokemon find(Long id){
        return  repository.findById(id).orElseThrow(()->new RuntimeException("no se encpontro"));
    }
}