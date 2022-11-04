package com.example.pokedex.services;

import com.example.pokedex.controllers.dtos.request.CreatePokeballRequest;
import com.example.pokedex.controllers.dtos.request.UpdatePokeballRequest;
import com.example.pokedex.controllers.dtos.response.*;
import com.example.pokedex.entities.Pokeball;
import com.example.pokedex.entities.projections.PokeballProjections;
import com.example.pokedex.entities.projections.SkillProjections;
import com.example.pokedex.entities.projections.TrainerProjections;
import com.example.pokedex.repositories.IPokeballRepository;
import com.example.pokedex.services.interfaces.IPokeballService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PokeballServiceImpl implements IPokeballService {
    @Autowired
    private IPokeballRepository repository;


    @Override
    public GetPokeballResponse get(Long id) {
        Pokeball pokeball = find(id);
        return from(pokeball);
    }

    @Override
    public CreatePokeballResponse create(CreatePokeballRequest request) {
        Pokeball pokeball = new Pokeball();
        pokeball.setName(request.getName());
        pokeball.setLevel(request.getLevel());
        pokeball.setRecommendation(request.getRecommendation());
        repository.save(pokeball);
        return to(pokeball);
    }


    @Override
    public UpdatePokeballResponse update(UpdatePokeballRequest request, Long id) {
        Pokeball pokeball = find(id);
        pokeball.setName(request.getName());
        pokeball.setLevel(request.getLevel());
        pokeball.setRecommendation(request.getRecommendation());
        repository.save(pokeball);
        return fromUpdate(pokeball);
    }

    @Override
    public List<GetPokeballResponse> list() {
        return repository.findAll().stream().map(this::from).collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<PokeballResponse> listAllTrainersByPokemonId(Long pokemonId) {
        List<PokeballProjections> trainers = repository.listAllTrainersByPokemonId(pokemonId);
        return trainers.stream().map(this::from).collect(Collectors.toList());
    }

    private PokeballResponse from (PokeballProjections pokeball){
        PokeballResponse response = new PokeballResponse();
        response.setId(pokeball.getId());
        response.setName(pokeball.getName());
        response.setLevel(pokeball.getLevel());
        response.setRecommendation(pokeball.getRecommendation());
        response.setImage(pokeball.getImage());
        return response;
    }

    public GetPokeballResponse from(Pokeball pokeball) {
        GetPokeballResponse response = new GetPokeballResponse();
        response.setId(pokeball.getId());
        response.setName(pokeball.getName());
        response.setLevel(pokeball.getLevel());
        response.setRecommendation(pokeball.getRecommendation());
        return response;
    }

    public CreatePokeballResponse to(Pokeball pokeball) {
        CreatePokeballResponse response = new CreatePokeballResponse();
        response.setId(pokeball.getId());
        response.setName(pokeball.getName());
        response.setLevel(pokeball.getLevel());
        response.setRecommendation(pokeball.getRecommendation());
        return response;
    }

    public UpdatePokeballResponse fromUpdate(Pokeball pokeball) {
        UpdatePokeballResponse response = new UpdatePokeballResponse();
        response.setId(pokeball.getId());
        response.setName(pokeball.getName());
        response.setLevel(pokeball.getLevel());
        response.setRecommendation(pokeball.getRecommendation());
        return response;
    }
    public Pokeball find(Long id){
        return  repository.findById(id).orElseThrow(()->new RuntimeException("no se encpontro"));
    }
}
