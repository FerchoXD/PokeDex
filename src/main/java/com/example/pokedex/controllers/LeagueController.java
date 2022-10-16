package com.example.pokedex.controllers;

import com.example.pokedex.controllers.dtos.request.CreateLeagueRequest;
import com.example.pokedex.controllers.dtos.request.UpdateLeagueRequest;
import com.example.pokedex.controllers.dtos.response.CreateLeagueResponse;
import com.example.pokedex.controllers.dtos.response.GetLeagueResponse;
import com.example.pokedex.controllers.dtos.response.UpdateLeagueResponse;
import com.example.pokedex.services.ServiceLeagueImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("league")
public class LeagueController {
    @Autowired
    private ServiceLeagueImpl service;

    @GetMapping("{id}")
    public GetLeagueResponse get(@PathVariable Long id){
        return service.get(id);
    }

    @PostMapping
    public CreateLeagueResponse Create(@RequestBody CreateLeagueRequest request){
        return service.create(request);
    }

    @PutMapping("{id}")
    public UpdateLeagueResponse update(@RequestBody UpdateLeagueRequest request, @PathVariable Long id){
        return service.update(request, id);
    }

    @GetMapping
    public List<GetLeagueResponse> list(){
        return service.list();
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }

}
