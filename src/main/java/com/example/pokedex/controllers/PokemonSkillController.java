package com.example.pokedex.controllers;

import com.example.pokedex.controllers.dtos.response.BaseResponse;
import com.example.pokedex.controllers.dtos.response.PokemonResponse;
import com.example.pokedex.controllers.dtos.response.SkillResponse;
import com.example.pokedex.services.PokemonSkillServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.Response;
import java.util.List;

@RestController
@RequestMapping("pokemon-skill")
public class PokemonSkillController {
    @Autowired
    private PokemonSkillServiceImpl service;

    @GetMapping("pokemon/skill/{pokemonId}")
    public ResponseEntity<BaseResponse> listAllSkillsByPokemonId(@PathVariable Long pokemonId){
        BaseResponse baseResponse = service.listAllSkillsByPokemonId(pokemonId);
        return new ResponseEntity<>(baseResponse,baseResponse.getHttpStatus());
    }

    @GetMapping("skill/pokemon/{skillId}")
    public ResponseEntity<BaseResponse> listAllPokemonBySkillsId(@PathVariable Long skillId){
        BaseResponse baseResponse = service.listAllPokemonBySkillsId(skillId);
        return new ResponseEntity<>(baseResponse,baseResponse.getHttpStatus());
    }
}
