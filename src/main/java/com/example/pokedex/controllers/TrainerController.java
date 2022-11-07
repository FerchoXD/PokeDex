package com.example.pokedex.controllers;

import com.example.pokedex.controllers.dtos.request.CreateTrainerRequest;
import com.example.pokedex.controllers.dtos.request.UpdateTrainerRequest;
import com.example.pokedex.controllers.dtos.response.BaseResponse;
import com.example.pokedex.controllers.dtos.response.CreateTrainerResponse;
import com.example.pokedex.controllers.dtos.response.GetTrainerResponse;
import com.example.pokedex.controllers.dtos.response.UpdateTrainerResponse;
import com.example.pokedex.services.TrainerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("trainer")
public class TrainerController {
    @Autowired
    private TrainerServiceImpl service;
    @GetMapping("{id}")
    public GetTrainerResponse get(@PathVariable Long id){
        return service.get(id);
    }

    @PostMapping
    public ResponseEntity<BaseResponse> Create(@RequestBody @Valid CreateTrainerRequest request){
        BaseResponse baseResponse = service.create(request);
        return new ResponseEntity<>(baseResponse,baseResponse.getHttpStatus());
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
