package com.example.pokedex.services.interfaces;

import com.example.pokedex.controllers.dtos.request.CreateForumRequest;
import com.example.pokedex.controllers.dtos.request.UpdateForumRequest;
import com.example.pokedex.controllers.dtos.request.UpdateLeagueRequest;
import com.example.pokedex.controllers.dtos.response.*;

import java.util.List;

public interface IForumService {
    GetForumResponse get(Long id);

    CreateForumResponse create(CreateForumRequest request);

    List<GetForumResponse> list();

    void delete(Long id);

    UpdateForumResponse update(UpdateForumRequest request, Long id);
}
