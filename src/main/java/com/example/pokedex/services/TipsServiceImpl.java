package com.example.pokedex.services;

import com.example.pokedex.controllers.dtos.request.CreateTipsRequest;
import com.example.pokedex.controllers.dtos.request.UpdateTipsRequest;
import com.example.pokedex.controllers.dtos.response.*;
import com.example.pokedex.entities.Skill;
import com.example.pokedex.entities.Tips;
import com.example.pokedex.repositories.ITipsRepository;
import com.example.pokedex.services.interfaces.ITipsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TipsServiceImpl implements ITipsService {
    @Autowired
    private ITipsRepository repository;

    @Override
    public GetTipsResponse get(Long id) {
        Tips tips = find(id);
        return from(tips);
    }

    @Override
    public CreateTipsResponse create(CreateTipsRequest request) {
        Tips tips = new Tips();
        tips.setDescription(request.getDescription());
        tips.setImage(request.getImage());
        repository.save(tips);
        return to(tips);
    }

    @Override
    public UpdateTipsResponse update(UpdateTipsRequest request, Long id) {
        Tips tips = find(id);
        tips.setDescription(request.getDescription());
        tips.setImage(request.getImage());
        repository.save(tips);
        return fromUpdate(tips);
    }

    @Override
    public List<GetTipsResponse> list() {
        return repository.findAll().stream().map(this::from).collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    public CreateTipsResponse to(Tips tips) {
        CreateTipsResponse response = new CreateTipsResponse();
        response.setId(tips.getId());
        response.setDescription(tips.getDescription());
        response.setImage(tips.getImage());
        return response;
    }

    public GetTipsResponse from(Tips tips) {
        GetTipsResponse response = new GetTipsResponse();
        response.setId(tips.getId());
        response.setDescription(tips.getDescription());
        response.setImage(tips.getImage());
        return response;
    }

    public UpdateTipsResponse fromUpdate(Tips tips) {
        UpdateTipsResponse response = new UpdateTipsResponse();
        response.setId(tips.getId());
        response.setDescription(tips.getDescription());
        response.setImage(tips.getImage());
        return response;
    }
    public Tips find(Long id){
        return  repository.findById(id).orElseThrow(()->new RuntimeException("no se encpontro"));
    }
}
