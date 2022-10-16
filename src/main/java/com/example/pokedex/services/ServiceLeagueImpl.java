package com.example.pokedex.services;

import com.example.pokedex.controllers.dtos.request.CreateLeagueRequest;
import com.example.pokedex.controllers.dtos.request.UpdateLeagueRequest;
import com.example.pokedex.controllers.dtos.response.CreateLeagueResponse;
import com.example.pokedex.controllers.dtos.response.GetLeagueResponse;
import com.example.pokedex.controllers.dtos.response.UpdateLeagueResponse;
import com.example.pokedex.entities.League;
import com.example.pokedex.repositories.ILeagueRepository;
import com.example.pokedex.services.interfaces.ILeagueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServiceLeagueImpl implements ILeagueService {
    @Autowired
    private ILeagueRepository repository;


    @Override
    public GetLeagueResponse get(Long id) {
        League league = find(id);
        return from(league);
    }

    @Override
    public CreateLeagueResponse create(CreateLeagueRequest request) {
        League league = new League();
        league.setName(request.getName());
        league.setRegion(request.getRegion());
        league.setLimitPokemon(request.getLimitpokemon());
        repository.save(league);
        return to(league);
    }


    @Override
    public UpdateLeagueResponse update(UpdateLeagueRequest request, Long id) {
        League league = find(id);
        league.setName(request.getName());
        league.setRegion(request.getRegion());
        league.setLimitPokemon(request.getLimitpokemon());
        repository.save(league);
        return fromUpdate(league);
    }

    @Override
    public List<GetLeagueResponse> list() {
        return repository.findAll().stream().map(this::from).collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    public GetLeagueResponse from(League league) {
        GetLeagueResponse response = new GetLeagueResponse();
        response.setId(league.getId());
        response.setName(league.getName());
        response.setRegion(league.getRegion());
        response.setLimitpokemon(league.getLimitPokemon());
        return response;
    }

    public CreateLeagueResponse to(League league) {
        CreateLeagueResponse response = new CreateLeagueResponse();
        response.setId(league.getId());
        response.setName(league.getName());
        response.setRegion(league.getRegion());
        response.setLimitpokemon(league.getLimitPokemon());
        return response;
    }

    public UpdateLeagueResponse fromUpdate(League league) {
        UpdateLeagueResponse response = new UpdateLeagueResponse();
        response.setId(league.getId());
        response.setName(league.getName());
        response.setRegion(league.getRegion());
        response.setLimitpokemon(league.getLimitPokemon());
        return response;
    }
    public League find(Long id){
        return  repository.findById(id).orElseThrow(()->new RuntimeException("no se encpontro"));
    }
}
