package com.example.pokedex.services.interfaces;

import com.example.pokedex.controllers.dtos.response.SkillResponse;
import com.example.pokedex.controllers.dtos.response.TrainerResponse;

import java.util.List;

public interface ITrainersForumService {

    List<TrainerResponse> listAllTrainersByForumId(Long forumId);
}
