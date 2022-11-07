package com.example.pokedex.services.interfaces;

import com.example.pokedex.controllers.dtos.response.BaseResponse;
import com.example.pokedex.controllers.dtos.response.LeagueResponse;
import com.example.pokedex.controllers.dtos.response.TrainerLeagueResponse;

import java.util.List;

public interface ITrainersLeagueService {
    BaseResponse listAllTrainersByLeagueId(Long leagueId);

    BaseResponse listAllLeaguesByTrainersId(Long trainerId);
}
