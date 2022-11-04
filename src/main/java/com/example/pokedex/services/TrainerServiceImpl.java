package com.example.pokedex.services;

import com.example.pokedex.controllers.dtos.request.CreateTrainerRequest;
import com.example.pokedex.controllers.dtos.request.UpdateTrainerRequest;
import com.example.pokedex.controllers.dtos.response.CreateTrainerResponse;
import com.example.pokedex.controllers.dtos.response.GetTrainerResponse;
import com.example.pokedex.controllers.dtos.response.UpdateTrainerResponse;
import com.example.pokedex.entities.Trainer;
import com.example.pokedex.repositories.ITrainerRepository;
import com.example.pokedex.services.interfaces.ITrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TrainerServiceImpl implements ITrainerService {
    @Autowired
    private ITrainerRepository repository;


    @Override
    public GetTrainerResponse get(Long id) {
        Trainer trainer = find(id);
        return from(trainer);
    }

    @Override
    public CreateTrainerResponse create(CreateTrainerRequest request) {
        Trainer trainer = new Trainer();
        trainer.setName(request.getName());
        trainer.setAge(request.getAge());
        trainer.setCategory(request.getCategory());
        repository.save(trainer);
        return to(trainer);
    }

    @Override
    public UpdateTrainerResponse update(UpdateTrainerRequest request, Long id) {
        Trainer trainer = find(id);
        trainer.setName(request.getName());
        trainer.setAge(request.getAge());
        trainer.setCategory(request.getCategory());
        repository.save(trainer);
        return fromUpdate(trainer);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<GetTrainerResponse> list() {
        return repository.findAll().stream().map(this::from).collect(Collectors.toList());
    }


    public CreateTrainerResponse to(Trainer trainer) {
        CreateTrainerResponse response = new CreateTrainerResponse();
        response.setId(trainer.getId());
        response.setName(trainer.getName());
        response.setAge(trainer.getAge());
        response.setCategory(trainer.getCategory());
        return response;
    }

    public GetTrainerResponse from(Trainer trainer) {
        GetTrainerResponse response = new GetTrainerResponse();
        response.setId(trainer.getId());
        response.setName(trainer.getName());
        response.setCategory(trainer.getCategory());
        response.setAge(trainer.getAge());
        return response;
    }

    public UpdateTrainerResponse fromUpdate(Trainer trainer) {
        UpdateTrainerResponse response = new UpdateTrainerResponse();
        response.setId(trainer.getId());
        response.setName(trainer.getName());
        response.setCategory(trainer.getCategory());
        response.setAge(trainer.getAge());
        return response;
    }
    public Trainer find(Long id){
        return  repository.findById(id).orElseThrow(()->new RuntimeException("no se encpontro"));
    }
}
