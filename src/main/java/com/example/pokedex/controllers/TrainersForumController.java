package com.example.pokedex.controllers;

import com.example.pokedex.controllers.dtos.response.SkillResponse;
import com.example.pokedex.controllers.dtos.response.TrainerResponse;
import com.example.pokedex.services.interfaces.ITrainersForumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("trainers_Forums")
public class TrainersForumController {
    @Autowired
    private ITrainersForumService service;

    @GetMapping("trainers/forum/{forumId}")
    public List<TrainerResponse> listAllTrainersByForumId(@PathVariable Long forumId){
        return service.listAllTrainersByForumId(forumId);
    }
}
