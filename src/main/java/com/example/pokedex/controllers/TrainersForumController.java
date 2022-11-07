package com.example.pokedex.controllers;

import com.example.pokedex.controllers.dtos.response.BaseResponse;
import com.example.pokedex.controllers.dtos.response.TrainerForumResponse;
import com.example.pokedex.services.interfaces.ITrainersForumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("trainer-Forum")
public class TrainersForumController {
    @Autowired
    private ITrainersForumService service;

    @GetMapping("trainers/forum/{forumId}")
    public ResponseEntity<BaseResponse> listAllTrainersByForumId(@PathVariable Long forumId){
        BaseResponse baseResponse = service.listAllTrainersByForumId(forumId);
        return new ResponseEntity<>(baseResponse,baseResponse.getHttpStatus());
    }
}
