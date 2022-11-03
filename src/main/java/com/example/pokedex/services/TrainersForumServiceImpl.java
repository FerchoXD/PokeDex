package com.example.pokedex.services;

import com.example.pokedex.controllers.dtos.response.SkillResponse;
import com.example.pokedex.controllers.dtos.response.TrainerResponse;
import com.example.pokedex.entities.projections.PokemonProjections;
import com.example.pokedex.entities.projections.SkillProjections;
import com.example.pokedex.entities.projections.TrainerProjections;
import com.example.pokedex.repositories.ITrainersForumRepository;
import com.example.pokedex.services.interfaces.ITrainersForumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TrainersForumServiceImpl implements ITrainersForumService {
    @Autowired
    private ITrainersForumRepository repository;
    @Override
    public List<TrainerResponse> listAllTrainersByForumId(Long forumId) {
        List<TrainerProjections> trainers = repository.listAllTrainersByForumId(forumId);
        return trainers.stream().map(this::from).collect(Collectors.toList());
    }

    private TrainerResponse from (TrainerProjections trainers){
        TrainerResponse response = new TrainerResponse();
        response.setId(trainers.getId());
        response.setName(trainers.getName());
        response.setAge(trainers.getAge());
        response.setNationality(trainers.getNationality());
        response.setProfilePicture(trainers.getProfilePicture());
        return response;
    }
}
