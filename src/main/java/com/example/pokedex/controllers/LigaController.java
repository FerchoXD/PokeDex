package com.example.pokedex.controllers;

import com.example.pokedex.controllers.dtos.request.CreateLigaRequest;
import com.example.pokedex.controllers.dtos.request.UpdateLigaRequest;
import com.example.pokedex.controllers.dtos.response.CreateLigaResponse;
import com.example.pokedex.controllers.dtos.response.GetLigaResponse;
import com.example.pokedex.controllers.dtos.response.UpdateLigaResponse;
import com.example.pokedex.services.ServiceLigaImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Liga")
public class LigaController {
    @Autowired
    private ServiceLigaImpl service;

    @GetMapping("{id}")
    public GetLigaResponse get(@PathVariable Long id){
        return service.get(id);
    }

    @PostMapping
    public CreateLigaResponse Create(@RequestBody CreateLigaRequest request){
        return service.create(request);
    }

    @PutMapping("{id}")
    public UpdateLigaResponse update(@RequestBody UpdateLigaRequest request, @PathVariable Long id){
        return service.update(request, id);
    }

    @GetMapping
    public List<GetLigaResponse> list(){
        return service.list();
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }

}
