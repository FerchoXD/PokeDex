package com.example.pokedex.services.interfaces;

import com.example.pokedex.controllers.dtos.response.BaseResponse;
import com.example.pokedex.controllers.dtos.response.TrainerForumResponse;

import java.util.List;

public interface ITrainersForumService {

    BaseResponse listAllTrainersByForumId(Long forumId);
}
