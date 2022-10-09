package com.example.pokedex.Entrenador.controller;

import com.example.pokedex.Entrenador.Service.ServiceEntrenadorImpl;
import com.example.pokedex.Entrenador.controller.dtos.request.CreateEntrenadorRequest;
import com.example.pokedex.Entrenador.controller.dtos.request.UpdateEntrenadorRequest;
import com.example.pokedex.Entrenador.controller.dtos.response.CreateEntrenadorResponse;
import com.example.pokedex.Entrenador.controller.dtos.response.GetEntrenadorResponse;
import com.example.pokedex.Entrenador.controller.dtos.response.UpdateEntrenadorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Entrenador")
public class EntrenadorController {
    @Autowired
    private ServiceEntrenadorImpl service;
    @GetMapping("{id_Entrenador}")
    public GetEntrenadorResponse get(@PathVariable Long id_Entrenador){
        return service.get(id_Entrenador);
    }

    @PostMapping
    public CreateEntrenadorResponse Create(@RequestBody CreateEntrenadorRequest request){
        return service.create(request);
    }

    @PutMapping("{id_Entrenador}")
    public UpdateEntrenadorResponse update(@RequestBody UpdateEntrenadorRequest request, @PathVariable Long id_Entrenador){
        return service.update(request, id_Entrenador);
    }

    @GetMapping
    public List<GetEntrenadorResponse> list(){
        return service.list();
    }

    @DeleteMapping("{id_Entrenador}")
    public void delete(@PathVariable Long id_Entrenador){
        service.delete(id_Entrenador);
    }
}
