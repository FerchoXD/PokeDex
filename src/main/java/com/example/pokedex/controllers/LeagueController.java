package com.example.pokedex.controllers;

import com.example.pokedex.controllers.dtos.request.CreateLeagueRequest;
import com.example.pokedex.controllers.dtos.request.UpdateLeagueRequest;
import com.example.pokedex.controllers.dtos.response.BaseResponse;
import com.example.pokedex.controllers.dtos.response.CreateLeagueResponse;
import com.example.pokedex.controllers.dtos.response.GetLeagueResponse;
import com.example.pokedex.controllers.dtos.response.UpdateLeagueResponse;
import com.example.pokedex.services.LeagueServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("league")
public class LeagueController {
    @Autowired
    private LeagueServiceImpl service;

    @GetMapping("{id}")
    public GetLeagueResponse get(@PathVariable Long id){
        return service.get(id);
    }

    @PostMapping
    public ResponseEntity<BaseResponse> Create(@RequestBody CreateLeagueRequest request){
        BaseResponse baseResponse = service.create(request);
        return new ResponseEntity<>(baseResponse,baseResponse.getHttpStatus());
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
