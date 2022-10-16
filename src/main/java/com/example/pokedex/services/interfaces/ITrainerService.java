package com.example.pokedex.services.interfaces;

import com.example.pokedex.controllers.dtos.request.CreateTrainerRequest;
import com.example.pokedex.controllers.dtos.request.UpdateTrainerRequest;
import com.example.pokedex.controllers.dtos.response.CreateTrainerResponse;
import com.example.pokedex.controllers.dtos.response.GetTrainerResponse;
import com.example.pokedex.controllers.dtos.response.UpdateTrainerResponse;

import java.util.List;

public interface ITrainerService {
    GetTrainerResponse get(Long id);

    CreateTrainerResponse create(CreateTrainerRequest request);

    UpdateTrainerResponse update(UpdateTrainerRequest request, Long id);

    List<GetTrainerResponse> list();

    void delete(Long id);
}
