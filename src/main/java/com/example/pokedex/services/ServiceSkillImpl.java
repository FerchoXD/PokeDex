package com.example.pokedex.services;

import com.example.pokedex.controllers.dtos.request.CreateSkillRequest;
import com.example.pokedex.controllers.dtos.request.UpdateSkillRequest;
import com.example.pokedex.controllers.dtos.response.CreateSkillResponse;
import com.example.pokedex.controllers.dtos.response.GetSkillResponse;
import com.example.pokedex.controllers.dtos.response.UpdateSkillResponse;
import com.example.pokedex.entities.Skill;
import com.example.pokedex.repositories.ISkillRepository;
import com.example.pokedex.services.interfaces.ISkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServiceSkillImpl implements ISkillService {
    @Autowired
    private ISkillRepository repository;


    @Override
    public GetSkillResponse get(Long id) {
        Skill skill = find(id);
        return from(skill);
    }

    @Override
    public CreateSkillResponse create(CreateSkillRequest request) {
        Skill skill = new Skill();
        skill.setName(request.getName());
        skill.setEffect(request.getEffect());
        skill.setType(request.getType());
        repository.save(skill);
        return to(skill);
    }

    @Override
    public UpdateSkillResponse update(UpdateSkillRequest request, Long id) {
        Skill skill = find(id);
        skill.setName(request.getName());
        skill.setEffect(request.getEffect());
        skill.setType(request.getType());
        repository.save(skill);
        return fromUpdate(skill);
    }

    @Override
    public List<GetSkillResponse> list() {
        return repository.findAll().stream().map(this::from).collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    public CreateSkillResponse to(Skill skill) {
        CreateSkillResponse response = new CreateSkillResponse();
        response.setId(skill.getId());
        response.setName(skill.getName());
        response.setEffect(skill.getEffect());
        response.setType(skill.getType());
        return response;
    }

    public GetSkillResponse from(Skill skill) {
        GetSkillResponse response = new GetSkillResponse();
        response.setId(skill.getId());
        response.setName(skill.getName());
        response.setType(skill.getType());
        response.setEffect(skill.getEffect());
        return response;
    }

    public UpdateSkillResponse fromUpdate(Skill skill) {
        UpdateSkillResponse response = new UpdateSkillResponse();
        response.setId(skill.getId());
        response.setName(skill.getName());
        response.setType(skill.getType());
        response.setEffect(skill.getEffect());
        return response;
    }
    public Skill find(Long id){
        return  repository.findById(id).orElseThrow(()->new RuntimeException("no se encpontro"));
    }
}
