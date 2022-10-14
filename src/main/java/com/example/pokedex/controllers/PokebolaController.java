package com.example.pokedex.controllers;

import com.example.pokedex.controllers.dtos.request.CreatePokebolaRequest;
import com.example.pokedex.controllers.dtos.request.UpdatePokebolaRequest;
import com.example.pokedex.controllers.dtos.response.CreatePokebolaResponse;
import com.example.pokedex.controllers.dtos.response.GetPokebolaResponse;
import com.example.pokedex.controllers.dtos.response.UpdatePokebolaResponse;
import com.example.pokedex.services.ServicePokebolaImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Pokebola")
public class PokebolaController {
    @Autowired
    private ServicePokebolaImpl service;

    @GetMapping("{id}")
    public GetPokebolaResponse get(@PathVariable Long id){
        return service.get(id);
    }

    @PostMapping
    public CreatePokebolaResponse Create(@RequestBody CreatePokebolaRequest request){
        return service.create(request);
    }

    @PutMapping("{id}")
    public UpdatePokebolaResponse update(@RequestBody UpdatePokebolaRequest request, @PathVariable Long id){
        return service.update(request, id);
    }

    @GetMapping
    public List<GetPokebolaResponse> list(){
        return service.list();
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }

}
