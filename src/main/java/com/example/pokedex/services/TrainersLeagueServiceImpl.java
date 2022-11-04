package com.example.pokedex.services;

import com.example.pokedex.controllers.dtos.response.TrainerResponse;
import com.example.pokedex.entities.projections.TrainerProjections;
import com.example.pokedex.repositories.ITrainersLeagueRepository;
import com.example.pokedex.services.interfaces.ITrainersLeagueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TrainersLeagueServiceImpl implements ITrainersLeagueService {
    @Autowired
    private ITrainersLeagueRepository repository;

    @Override
    public List<TrainerResponse> listAllTrainersByLeagueId(Long leagueId) {
        List<TrainerProjections> trainers = repository.listAllTrainersByLeagueId(leagueId);
        return trainers.stream().map(this::from).collect(Collectors.toList());
    }

    private TrainerResponse from (TrainerProjections trainers){
        TrainerResponse response = new TrainerResponse();
        response.setId(trainers.getId());
        response.setName(trainers.getName());
        response.setAge(trainers.getAge());
        response.setCategory(trainers.getCategory());
        response.setProfilePicture(trainers.getProfilePicture());
        return response;
    }


}
