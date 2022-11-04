package com.example.pokedex.controllers;

import com.example.pokedex.controllers.dtos.response.TrainerResponse;
import com.example.pokedex.services.interfaces.ITrainersLeagueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("trainers-league")
public class TrainersLeagueController {
    @Autowired
    private ITrainersLeagueService service;

    @GetMapping("trainers/league/{leagueId}")
    public List<TrainerResponse> listAllTrainersByLeagueId(@PathVariable Long leagueId){
        return service.listAllTrainersByLeagueId(leagueId);
    }
}
