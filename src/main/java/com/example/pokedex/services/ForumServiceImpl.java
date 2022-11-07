package com.example.pokedex.services;

import com.example.pokedex.controllers.dtos.request.CreateForumRequest;
import com.example.pokedex.controllers.dtos.request.UpdateForumRequest;
import com.example.pokedex.controllers.dtos.request.UpdateLeagueRequest;
import com.example.pokedex.controllers.dtos.response.*;
import com.example.pokedex.entities.Forum;
import com.example.pokedex.entities.League;
import com.example.pokedex.repositories.IForumRepository;
import com.example.pokedex.services.interfaces.IForumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ForumServiceImpl implements IForumService {
    @Autowired
    private IForumRepository repository;

    @Override
    public GetForumResponse get(Long id) {
        Forum forum = find(id);
        return from(forum);
    }

    @Override
    public BaseResponse create(CreateForumRequest request) {
        Forum forum = to(request);
        return BaseResponse.builder()
                .data(from(repository.save(forum)))
                .message("Forum Created correctly")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.CREATED).build();
    }

    @Override
    public UpdateForumResponse update(UpdateForumRequest request, Long id) {
        Forum forum = find(id);
        forum.setTopic(request.getTopic());
        forum.setHour(request.getHour());
        forum.setDate(request.getDate());
        repository.save(forum);
        return fromUpdate(forum);
    }

    @Override
    public List<GetForumResponse> list() {
        return repository.findAll()
                .stream()
                .map(this::from)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }



    public GetForumResponse from(Forum forum) {
        GetForumResponse response = new GetForumResponse();
        response.setId(forum.getId());
        response.setTopic(forum.getTopic());
        response.setHour(forum.getHour());
        response.setDate(forum.getDate());
        return response;
    }

    private Forum to(CreateForumRequest request) {
        Forum forum = new Forum();
        forum.setTopic(request.getTopic());
        forum.setDate(request.getDate());
        forum.setHour(request.getHour());
        return forum;
    }

    public UpdateForumResponse fromUpdate(Forum forum) {
        UpdateForumResponse response = new UpdateForumResponse();
        response.setId(forum.getId());
        response.setTopic(forum.getTopic());
        response.setHour(forum.getHour());
        response.setDate(forum.getDate());
        return response;
    }

    public Forum save(Forum forum) {
        return repository.save(forum);
    }

    public Forum find(Long id){
        return  repository.findById(id).orElseThrow(()->new RuntimeException("no se encpontro"));
    }
}
