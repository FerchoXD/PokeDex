package com.example.pokedex.services;

import com.example.pokedex.controllers.dtos.response.BaseResponse;
import com.example.pokedex.controllers.dtos.response.TrainerForumResponse;
import com.example.pokedex.entities.projections.TrainerForumProjections;
import com.example.pokedex.repositories.ITrainersForumRepository;
import com.example.pokedex.services.interfaces.ITrainersForumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TrainersForumServiceImpl implements ITrainersForumService {
    @Autowired
    private ITrainersForumRepository repository;
    @Override
    public BaseResponse listAllTrainersByForumId(Long forumId) {
        List<TrainerForumProjections> trainers = repository.listAllTrainersByForumId(forumId);
        List<TrainerForumResponse> response = trainers.stream().map(this::from).collect(Collectors.toList());
        return BaseResponse.builder()
                .data(response)
                .message("Trainers list by Forum Id")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.OK).build();
    }

    private TrainerForumResponse from (TrainerForumProjections trainers){
        TrainerForumResponse response = new TrainerForumResponse();
        response.setId(trainers.getId());
        response.setName(trainers.getName());
        response.setAge(trainers.getAge());
        response.setCategory(trainers.getCategory());
        response.setImage(trainers.getImage());
        response.setForumsId(trainers.getForumsId());
        response.setForumsTopic(trainers.getForumsTopic());
        return response;
    }
}
