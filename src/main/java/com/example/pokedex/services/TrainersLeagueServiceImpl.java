package com.example.pokedex.services;

import com.example.pokedex.controllers.dtos.response.BaseResponse;
import com.example.pokedex.controllers.dtos.response.LeagueResponse;
import com.example.pokedex.controllers.dtos.response.TrainerLeagueResponse;
import com.example.pokedex.entities.projections.LeagueProjections;
import com.example.pokedex.entities.projections.TrainerLeagueProjections;
import com.example.pokedex.repositories.ITrainersLeagueRepository;
import com.example.pokedex.services.interfaces.ITrainersLeagueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TrainersLeagueServiceImpl implements ITrainersLeagueService {
    @Autowired
    private ITrainersLeagueRepository repository;

    @Override
    public BaseResponse listAllTrainersByLeagueId(Long leagueId) {
        List<TrainerLeagueProjections> trainers = repository.listAllTrainersByLeagueId(leagueId);
        List<TrainerLeagueResponse> response = trainers.stream().map(this::from).collect(Collectors.toList());
        return BaseResponse.builder()
                .data(response)
                .message("Trainer list by league id")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.OK).build();
    }

    @Override
    public BaseResponse listAllLeaguesByTrainersId(Long trainerId) {
        List<LeagueProjections> leagues = repository.listAllLeaguesByTrainersId(trainerId);
        List<LeagueResponse> response = leagues.stream().map(this::from).collect(Collectors.toList());
        return BaseResponse.builder()
                .data(response)
                .message("Leagues list by Trainer id")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.OK).build();
    }

    private LeagueResponse from (LeagueProjections league){
        LeagueResponse response = new LeagueResponse();
        response.setId(league.getId());
        response.setName(league.getName());
        response.setRegion(league.getRegion());
        response.setImage(league.getImage());
        response.setTrainersId(league.getTrainersId());
        response.setTrainersName(league.getTrainersName());
        return response;
    }

    private TrainerLeagueResponse from (TrainerLeagueProjections trainers){
        TrainerLeagueResponse response = new TrainerLeagueResponse();
        response.setId(trainers.getId());
        response.setName(trainers.getName());
        response.setAge(trainers.getAge());
        response.setCategory(trainers.getCategory());
        response.setImage(trainers.getImage());
        response.setLeaguesName(trainers.getLeaguesName());
        response.setLeaguesId(trainers.getLeaguesId());
        return response;
    }


}
