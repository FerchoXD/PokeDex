package com.example.pokedex.services.interfaces;

import com.example.pokedex.controllers.dtos.response.TrainerResponse;

import java.util.List;

public interface ITrainersLeagueService {
    List<TrainerResponse> listAllTrainersByLeagueId(Long leagueId);
}
