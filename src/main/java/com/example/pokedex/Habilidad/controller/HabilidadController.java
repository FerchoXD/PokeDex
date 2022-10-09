package com.example.pokedex.Habilidad.controller;

import com.example.pokedex.Habilidad.Service.ServiceHabilidadImpl;
import com.example.pokedex.Habilidad.controller.dtos.request.CreateHabilidadRequest;
import com.example.pokedex.Habilidad.controller.dtos.request.UpdateHabilidadRequest;
import com.example.pokedex.Habilidad.controller.dtos.response.CreateHabilidadResponse;
import com.example.pokedex.Habilidad.controller.dtos.response.GetHabilidadResponse;
import com.example.pokedex.Habilidad.controller.dtos.response.UpdateHabilidadResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Habilidad")
public class HabilidadController {
    @Autowired
    private ServiceHabilidadImpl service;
    @GetMapping("{id_Habilidad}")
    public GetHabilidadResponse get(@PathVariable Long id_Habilidad){
        return service.get(id_Habilidad);
    }

    @PostMapping
    public CreateHabilidadResponse Create(@RequestBody CreateHabilidadRequest request){
        return service.create(request);
    }

    @PutMapping("{id_Habilidad}")
    public UpdateHabilidadResponse update(@RequestBody UpdateHabilidadRequest request, @PathVariable Long id_Habilidad){
        return service.update(request, id_Habilidad);
    }

    @GetMapping
    public List<GetHabilidadResponse> list(){
        return service.list();
    }

    @DeleteMapping("{id_Habilidad}")
    public void delete(@PathVariable Long id_Habilidad){
        service.delete(id_Habilidad);
    }
}
