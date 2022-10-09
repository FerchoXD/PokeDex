package com.example.pokedex.pokemon.Service;

import com.example.pokedex.pokemon.Controller.dtos.request.CreatePokemonRequest;
import com.example.pokedex.pokemon.Controller.dtos.request.UpdatePokemonRequest;
import com.example.pokedex.pokemon.Controller.dtos.response.CreatePokemonResponse;
import com.example.pokedex.pokemon.Controller.dtos.response.GetPokemonResponse;
import com.example.pokedex.pokemon.Controller.dtos.response.UpdatePokemonResponse;
import com.example.pokedex.pokemon.Entity.Pokemon;
import com.example.pokedex.pokemon.Repository.IPokemonRepository;
import com.example.pokedex.pokemon.Service.Interface.IPokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServicePokemonImpl implements IPokemonService {
    @Autowired
    private IPokemonRepository repository;


    @Override
    public GetPokemonResponse get(Long id_Pokemon) {
        Pokemon pokemon = find(id_Pokemon);
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
    public UpdatePokemonResponse update(UpdatePokemonRequest request, Long id_Pokemon) {
        Pokemon pokemon = find(id_Pokemon);
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
    public void delete(Long id_pokemon) {
        repository.deleteById(id_pokemon);
    }

    public CreatePokemonResponse to(Pokemon pokemon) {
        CreatePokemonResponse response = new CreatePokemonResponse();
        response.setId_Pokemon(pokemon.getId_Pokemon());
        response.setNombre(pokemon.getNombre());
        response.setEspecie(pokemon.getEspecie());
        response.setTipo(pokemon.getTipo());
        response.setColor(pokemon.getColor());
        return response;
    }

    public GetPokemonResponse from(Pokemon pokemon) {
        GetPokemonResponse response = new GetPokemonResponse();
        response.setId_Pokemon(pokemon.getId_Pokemon());
        response.setTipo(pokemon.getTipo());
        response.setEspecie(pokemon.getEspecie());
        response.setNombre(pokemon.getNombre());
        response.setColor(pokemon.getColor());
        return response;
    }

    public UpdatePokemonResponse fromUpdate(Pokemon pokemon) {
        UpdatePokemonResponse response = new UpdatePokemonResponse();
        response.setId_Pokemon(pokemon.getId_Pokemon());
        response.setNombre(pokemon.getNombre());
        response.setTipo(pokemon.getTipo());
        response.setEspecie(pokemon.getEspecie());
        response.setColor(pokemon.getColor());
        return response;
    }
    public Pokemon find(Long id_Pokemon){
        return  repository.findById(id_Pokemon).orElseThrow(()->new RuntimeException("no se encpontro"));
    }
}
