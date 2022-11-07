package com.example.pokedex.controllers;

import com.example.pokedex.controllers.dtos.response.BaseResponse;
import com.example.pokedex.controllers.dtos.response.LeagueResponse;
import com.example.pokedex.controllers.dtos.response.TrainerLeagueResponse;
import com.example.pokedex.services.interfaces.ITrainersLeagueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("trainer-league")
public class TrainersLeagueController {
    @Autowired
    private ITrainersLeagueService service;

    @GetMapping("trainers/league/{leagueId}")
    public ResponseEntity<BaseResponse> listAllTrainersByLeagueId(@PathVariable Long leagueId){
        BaseResponse baseResponse = service.listAllTrainersByLeagueId(leagueId);
        return new ResponseEntity<>(baseResponse,baseResponse.getHttpStatus());
    }

    @GetMapping("leagues/trainer/{trainerId}")
    public ResponseEntity<BaseResponse> listAllLeaguesByTrainerId(@PathVariable Long trainerId){
        BaseResponse baseResponse = service.listAllLeaguesByTrainersId(trainerId);
        return new ResponseEntity<>(baseResponse,baseResponse.getHttpStatus());
    }
}
