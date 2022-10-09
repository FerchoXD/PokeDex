package com.example.pokedex.Liga.Controller;

import com.example.pokedex.Liga.Controller.dtos.Request.CreateLigaRequest;
import com.example.pokedex.Liga.Controller.dtos.Request.UpdateLigaRequest;
import com.example.pokedex.Liga.Controller.dtos.Response.CreateLigaResponse;
import com.example.pokedex.Liga.Controller.dtos.Response.GetLigaResponse;
import com.example.pokedex.Liga.Controller.dtos.Response.UpdateLigaResponse;
import com.example.pokedex.Liga.Service.ServiceLigaImpl;
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
