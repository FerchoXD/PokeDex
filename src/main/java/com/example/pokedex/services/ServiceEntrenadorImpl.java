package com.example.pokedex.services;

import com.example.pokedex.controllers.dtos.request.CreateEntrenadorRequest;
import com.example.pokedex.controllers.dtos.request.UpdateEntrenadorRequest;
import com.example.pokedex.controllers.dtos.response.CreateEntrenadorResponse;
import com.example.pokedex.controllers.dtos.response.GetEntrenadorResponse;
import com.example.pokedex.controllers.dtos.response.UpdateEntrenadorResponse;
import com.example.pokedex.entities.Entrenador;
import com.example.pokedex.repositories.IEntrenadorRepository;
import com.example.pokedex.services.interfaces.IEntrenadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServiceEntrenadorImpl implements IEntrenadorService {
    @Autowired
    private IEntrenadorRepository repository;


    @Override
    public GetEntrenadorResponse get(Long id) {
        Entrenador entrenador = find(id);
        return from(entrenador);
    }

    @Override
    public CreateEntrenadorResponse create(CreateEntrenadorRequest request) {
        Entrenador entrenador = new Entrenador();
        entrenador.setNombre(request.getNombre());
        entrenador.setEdad(request.getEdad());
        entrenador.setNacionalidad(request.getNacionalidad());
        repository.save(entrenador);
        return to(entrenador);
    }

    @Override
    public UpdateEntrenadorResponse update(UpdateEntrenadorRequest request, Long id) {
        Entrenador entrenador = find(id);
        entrenador.setNombre(request.getNombre());
        entrenador.setEdad(request.getEdad());
        entrenador.setNacionalidad(request.getNacionalidad());
        repository.save(entrenador);
        return fromUpdate(entrenador);
    }

    @Override
    public List<GetEntrenadorResponse> list() {
        return repository.findAll().stream().map(this::from).collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    public CreateEntrenadorResponse to(Entrenador entrenador) {
        CreateEntrenadorResponse response = new CreateEntrenadorResponse();
        response.setId(entrenador.getId());
        response.setNombre(entrenador.getNombre());
        response.setEdad(entrenador.getEdad());
        response.setNacionalidad(entrenador.getNacionalidad());
        return response;
    }

    public GetEntrenadorResponse from(Entrenador entrenador) {
        GetEntrenadorResponse response = new GetEntrenadorResponse();
        response.setId(entrenador.getId());
        response.setNombre(entrenador.getNombre());
        response.setNacionalidad(entrenador.getNacionalidad());
        response.setEdad(entrenador.getEdad());
        return response;
    }

    public UpdateEntrenadorResponse fromUpdate(Entrenador entrenador) {
        UpdateEntrenadorResponse response = new UpdateEntrenadorResponse();
        response.setId(entrenador.getId());
        response.setNombre(entrenador.getNombre());
        response.setNacionalidad(entrenador.getNacionalidad());
        response.setEdad(entrenador.getEdad());
        return response;
    }
    public Entrenador find(Long id){
        return  repository.findById(id).orElseThrow(()->new RuntimeException("no se encpontro"));
    }
}
