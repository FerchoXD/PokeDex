package com.example.pokedex.Pokebola.Controller;

import com.example.pokedex.Pokebola.Controller.dtos.Request.CreatePokebolaRequest;
import com.example.pokedex.Pokebola.Controller.dtos.Request.UpdatePokebolaRequest;
import com.example.pokedex.Pokebola.Controller.dtos.Response.CreatePokebolaResponse;
import com.example.pokedex.Pokebola.Controller.dtos.Response.GetPokebolaResponse;
import com.example.pokedex.Pokebola.Controller.dtos.Response.UpdatePokebolaResponse;
import com.example.pokedex.Pokebola.Service.ServicePokebolaImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Pokebola")
public class PokebolaController {
    @Autowired
    private ServicePokebolaImpl service;

    @GetMapping("{id_Pokebola}")
    public GetPokebolaResponse get(@PathVariable Long id_Pokebola){
        return service.get(id_Pokebola);
    }

    @PostMapping
    public CreatePokebolaResponse Create(@RequestBody CreatePokebolaRequest request){
        return service.create(request);
    }

    @PutMapping("{id_Pokebola}")
    public UpdatePokebolaResponse update(@RequestBody UpdatePokebolaRequest request, @PathVariable Long id_Pokebola){
        return service.update(request, id_Pokebola);
    }

    @GetMapping
    public List<GetPokebolaResponse> list(){
        return service.list();
    }

    @DeleteMapping("{id_Pokebola}")
    public void delete(@PathVariable Long id_Pokebola){
        service.delete(id_Pokebola);
    }

}
