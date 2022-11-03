package com.example.pokedex.services.interfaces;

import com.example.pokedex.controllers.dtos.request.CreateCommentRequest;
import com.example.pokedex.controllers.dtos.request.UpdateCommentRequest;
import com.example.pokedex.controllers.dtos.response.CreateCommentResponse;
import com.example.pokedex.controllers.dtos.response.GetCommentResponse;
import com.example.pokedex.controllers.dtos.response.UpdateCommentResponse;

import java.util.List;

public interface ICommentService {
    GetCommentResponse get(Long id);

    CreateCommentResponse create(CreateCommentRequest request);

    UpdateCommentResponse update(UpdateCommentRequest request, Long id);

    List<GetCommentResponse> list();

    void delete(Long id);
}
