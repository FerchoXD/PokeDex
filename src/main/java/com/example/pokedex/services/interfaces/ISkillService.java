package com.example.pokedex.services.interfaces;

import com.example.pokedex.controllers.dtos.request.CreateSkillRequest;
import com.example.pokedex.controllers.dtos.request.UpdateSkillRequest;
import com.example.pokedex.controllers.dtos.response.CreateSkillResponse;
import com.example.pokedex.controllers.dtos.response.GetSkillResponse;
import com.example.pokedex.controllers.dtos.response.UpdateSkillResponse;

import java.util.List;

public interface ISkillService {
    GetSkillResponse get(Long id);

    CreateSkillResponse create(CreateSkillRequest request);

    UpdateSkillResponse update(UpdateSkillRequest request, Long id);

    List<GetSkillResponse> list();

    void delete(Long id);
}
