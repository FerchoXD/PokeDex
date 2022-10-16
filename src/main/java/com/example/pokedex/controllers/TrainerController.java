package com.example.pokedex.controllers;

import com.example.pokedex.controllers.dtos.request.CreateTrainerRequest;
import com.example.pokedex.controllers.dtos.request.UpdateTrainerRequest;
import com.example.pokedex.controllers.dtos.response.CreateTrainerResponse;
import com.example.pokedex.controllers.dtos.response.GetTrainerResponse;
import com.example.pokedex.controllers.dtos.response.UpdateTrainerResponse;
import com.example.pokedex.services.ServiceTrainerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("trainer")
public class TrainerController {
    @Autowired
    private ServiceTrainerImpl service;
    @GetMapping("{id}")
    public GetTrainerResponse get(@PathVariable Long id){
        return service.get(id);
    }

    @PostMapping
    public CreateTrainerResponse Create(@RequestBody CreateTrainerRequest request){
        return service.create(request);
    }

    @PutMapping("{id}")
    public UpdateTrainerResponse update(@RequestBody UpdateTrainerRequest request, @PathVariable Long id){
        return service.update(request, id);
    }

    @GetMapping
    public List<GetTrainerResponse> list(){
        return service.list();
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }
}
