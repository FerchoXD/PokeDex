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

    @GetMapping("{id_Liga}")
    public GetLigaResponse get(@PathVariable Long id_Liga){
        return service.get(id_Liga);
    }

    @PostMapping
    public CreateLigaResponse Create(@RequestBody CreateLigaRequest request){
        return service.create(request);
    }

    @PutMapping("{id_Liga}")
    public UpdateLigaResponse update(@RequestBody UpdateLigaRequest request, @PathVariable Long id_Liga){
        return service.update(request, id_Liga);
    }

    @GetMapping
    public List<GetLigaResponse> list(){
        return service.list();
    }

    @DeleteMapping("{id_Liga}")
    public void delete(@PathVariable Long id_Liga){
        service.delete(id_Liga);
    }

}
