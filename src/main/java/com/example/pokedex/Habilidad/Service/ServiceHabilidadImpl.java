package com.example.pokedex.Habilidad.Service;

import com.example.pokedex.Habilidad.controller.dtos.response.CreateHabilidadResponse;
import com.example.pokedex.Habilidad.controller.dtos.response.GetHabilidadResponse;
import com.example.pokedex.Habilidad.Entity.Habilidad;
import com.example.pokedex.Habilidad.Repository.IHabilidadRepository;
import com.example.pokedex.Habilidad.Service.Interface.IHabilidadService;
import com.example.pokedex.Habilidad.controller.dtos.request.CreateHabilidadRequest;
import com.example.pokedex.Habilidad.controller.dtos.request.UpdateHabilidadRequest;
import com.example.pokedex.Habilidad.controller.dtos.response.UpdateHabilidadResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServiceHabilidadImpl implements IHabilidadService {
    @Autowired
    private IHabilidadRepository repository;


    @Override
    public GetHabilidadResponse get(Long id) {
        Habilidad habilidad = find(id);
        return from(habilidad);
    }

    @Override
    public CreateHabilidadResponse create(CreateHabilidadRequest request) {
        Habilidad habilidad = new Habilidad();
        habilidad.setNombre(request.getNombre());
        habilidad.setEfecto(request.getEfecto());
        habilidad.setTipo(request.getTipo());
        repository.save(habilidad);
        return to(habilidad);
    }

    @Override
    public UpdateHabilidadResponse update(UpdateHabilidadRequest request, Long id) {
        Habilidad habilidad = find(id);
        habilidad.setNombre(request.getNombre());
        habilidad.setEfecto(request.getEfecto());
        habilidad.setTipo(request.getTipo());
        repository.save(habilidad);
        return fromUpdate(habilidad);
    }

    @Override
    public List<GetHabilidadResponse> list() {
        return repository.findAll().stream().map(this::from).collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    public CreateHabilidadResponse to(Habilidad habilidad) {
        CreateHabilidadResponse response = new CreateHabilidadResponse();
        response.setId(habilidad.getId());
        response.setNombre(habilidad.getNombre());
        response.setEfecto(habilidad.getEfecto());
        response.setTipo(habilidad.getTipo());
        return response;
    }

    public GetHabilidadResponse from(Habilidad habilidad) {
        GetHabilidadResponse response = new GetHabilidadResponse();
        response.setId(habilidad.getId());
        response.setNombre(habilidad.getNombre());
        response.setTipo(habilidad.getTipo());
        response.setEfecto(habilidad.getEfecto());
        return response;
    }

    public UpdateHabilidadResponse fromUpdate(Habilidad habilidad) {
        UpdateHabilidadResponse response = new UpdateHabilidadResponse();
        response.setId(habilidad.getId());
        response.setNombre(habilidad.getNombre());
        response.setTipo(habilidad.getTipo());
        response.setEfecto(habilidad.getEfecto());
        return response;
    }
    public Habilidad find(Long id){
        return  repository.findById(id).orElseThrow(()->new RuntimeException("no se encpontro"));
    }
}
