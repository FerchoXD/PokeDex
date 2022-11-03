package com.example.pokedex.services;

import com.example.pokedex.controllers.dtos.request.CreateCommentRequest;
import com.example.pokedex.controllers.dtos.request.UpdateCommentRequest;
import com.example.pokedex.controllers.dtos.response.*;
import com.example.pokedex.entities.Comment;
import com.example.pokedex.repositories.ICommentRepository;
import com.example.pokedex.services.interfaces.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements ICommentService {
    @Autowired
    private ICommentRepository repository;

    @Override
    public GetCommentResponse get(Long id) {
        Comment comment = find(id);
        return from(comment);
    }

    @Override
    public CreateCommentResponse create(CreateCommentRequest request) {
        Comment comment = new Comment();
        comment.setHour(request.getHour());
        comment.setTitle(request.getTitle());
        comment.setDescription(request.getDescription());
        repository.save(comment);
        return to(comment);
    }

    @Override
    public UpdateCommentResponse update(UpdateCommentRequest request, Long id) {
        Comment comment = find(id);
        comment.setHour(request.getHour());
        comment.setTitle(request.getTitle());
        comment.setDescription(request.getDescription());
        repository.save(comment);
        return fromUpdate(comment);
    }

    @Override
    public List<GetCommentResponse> list() {
        return repository.findAll().stream().map(this::from).collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    public CreateCommentResponse to(Comment comment) {
        CreateCommentResponse response = new CreateCommentResponse();
        response.setId(comment.getId());
        response.setHour(comment.getHour());
        response.setTitle(comment.getTitle());
        response.setDescription(comment.getDescription());
        return response;
    }

    public GetCommentResponse from(Comment comment) {
        GetCommentResponse response = new GetCommentResponse();
        response.setId(comment.getId());
        response.setHour(comment.getHour());
        response.setTitle(comment.getTitle());
        response.setDescription(comment.getDescription());
        return response;
    }

    public UpdateCommentResponse fromUpdate(Comment comment) {
        UpdateCommentResponse response = new UpdateCommentResponse();
        response.setId(comment.getId());
        response.setHour(comment.getHour());
        response.setTitle(comment.getTitle());
        response.setDescription(comment.getDescription());
        return response;
    }
    public Comment find(Long id){
        return  repository.findById(id).orElseThrow(()->new RuntimeException("no se encpontro"));
    }
}
