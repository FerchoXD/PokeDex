package com.example.pokedex.services.interfaces;

import com.example.pokedex.controllers.dtos.request.CreateLeagueRequest;
import com.example.pokedex.controllers.dtos.request.UpdateLeagueRequest;
import com.example.pokedex.controllers.dtos.response.BaseResponse;
import com.example.pokedex.controllers.dtos.response.CreateLeagueResponse;
import com.example.pokedex.controllers.dtos.response.GetLeagueResponse;
import com.example.pokedex.controllers.dtos.response.UpdateLeagueResponse;

import java.util.List;

public interface ILeagueService {
    GetLeagueResponse get(Long id);

    BaseResponse create(CreateLeagueRequest request);

    UpdateLeagueResponse update(UpdateLeagueRequest request, Long id);

    List<GetLeagueResponse> list();

    void delete(Long id);
}
