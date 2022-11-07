package com.example.pokedex.services.interfaces;

import com.example.pokedex.controllers.dtos.request.CreateTipsRequest;
import com.example.pokedex.controllers.dtos.request.UpdateTipsRequest;
import com.example.pokedex.controllers.dtos.response.*;

import java.util.List;

public interface ITipsService {
    GetTipsResponse get(Long id);

    BaseResponse create(CreateTipsRequest request);

    UpdateTipsResponse update(UpdateTipsRequest request, Long id);

    List<GetTipsResponse> list();

    void delete(Long id);

    List<TipsResponse> listAllTipsByTrainersId(Long trainersId);
}
