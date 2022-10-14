package com.example.pokedex.controllers;

import com.example.pokedex.controllers.dtos.request.CreateEntrenadorRequest;
import com.example.pokedex.controllers.dtos.request.UpdateEntrenadorRequest;
import com.example.pokedex.controllers.dtos.response.CreateEntrenadorResponse;
import com.example.pokedex.controllers.dtos.response.GetEntrenadorResponse;
import com.example.pokedex.controllers.dtos.response.UpdateEntrenadorResponse;
import com.example.pokedex.services.ServiceEntrenadorImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Entrenador")
public class EntrenadorController {
    @Autowired
    private ServiceEntrenadorImpl service;
    @GetMapping("{id}")
    public GetEntrenadorResponse get(@PathVariable Long id){
        return service.get(id);
    }

    @PostMapping
    public CreateEntrenadorResponse Create(@RequestBody CreateEntrenadorRequest request){
        return service.create(request);
    }

    @PutMapping("{id}")
    public UpdateEntrenadorResponse update(@RequestBody UpdateEntrenadorRequest request, @PathVariable Long id){
        return service.update(request, id);
    }

    @GetMapping
    public List<GetEntrenadorResponse> list(){
        return service.list();
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }
}
