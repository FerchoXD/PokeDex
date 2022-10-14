package com.example.pokedex.services;

import com.example.pokedex.controllers.dtos.request.CreateLigaRequest;
import com.example.pokedex.controllers.dtos.request.UpdateLigaRequest;
import com.example.pokedex.controllers.dtos.response.CreateLigaResponse;
import com.example.pokedex.controllers.dtos.response.GetLigaResponse;
import com.example.pokedex.controllers.dtos.response.UpdateLigaResponse;
import com.example.pokedex.entities.Liga;
import com.example.pokedex.repositories.ILigaRepository;
import com.example.pokedex.services.interfaces.ILigaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServiceLigaImpl implements ILigaService {
    @Autowired
    private ILigaRepository repository;


    @Override
    public GetLigaResponse get(Long id) {
        Liga liga = find(id);
        return from(liga);
    }

    @Override
    public CreateLigaResponse create(CreateLigaRequest request) {
        Liga liga = new Liga();
        liga.setNombre(request.getNombre());
        liga.setRegion(request.getRegion());
        liga.setLimitepokemon(request.getLimitepokemon());
        repository.save(liga);
        return to(liga);
    }


    @Override
    public UpdateLigaResponse update(UpdateLigaRequest request, Long id) {
        Liga liga = find(id);
        liga.setNombre(request.getNombre());
        liga.setRegion(request.getRegion());
        liga.setLimitepokemon(request.getLimitepokemon());
        repository.save(liga);
        return fromUpdate(liga);
    }

    @Override
    public List<GetLigaResponse> list() {
        return repository.findAll().stream().map(this::from).collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    public GetLigaResponse from(Liga liga) {
        GetLigaResponse response = new GetLigaResponse();
        response.setId(liga.getId());
        response.setNombre(liga.getNombre());
        response.setRegion(liga.getRegion());
        response.setLimitepokemon(liga.getLimitepokemon());
        return response;
    }

    public CreateLigaResponse to(Liga liga) {
        CreateLigaResponse response = new CreateLigaResponse();
        response.setId(liga.getId());
        response.setNombre(liga.getNombre());
        response.setRegion(liga.getRegion());
        response.setLimitepokemon(liga.getLimitepokemon());
        return response;
    }

    public UpdateLigaResponse fromUpdate(Liga liga) {
        UpdateLigaResponse response = new UpdateLigaResponse();
        response.setId(liga.getId());
        response.setNombre(liga.getNombre());
        response.setRegion(liga.getRegion());
        response.setLimitepokemon(liga.getLimitepokemon());
        return response;
    }
    public Liga find(Long id){
        return  repository.findById(id).orElseThrow(()->new RuntimeException("no se encpontro"));
    }
}
