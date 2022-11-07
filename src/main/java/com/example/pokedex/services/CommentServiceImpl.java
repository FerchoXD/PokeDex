package com.example.pokedex.services;

import com.example.pokedex.controllers.dtos.request.CreateCommentRequest;
import com.example.pokedex.controllers.dtos.request.UpdateCommentRequest;
import com.example.pokedex.controllers.dtos.response.*;
import com.example.pokedex.controllers.exceptions.UpchiapasException;
import com.example.pokedex.entities.Comment;
import com.example.pokedex.repositories.ICommentRepository;
import com.example.pokedex.services.interfaces.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public BaseResponse create(CreateCommentRequest request) {
        Comment comment = to(request);
        return BaseResponse.builder()
                .data(from(repository.save(comment)))
                .message("Comment Created correctly")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.CREATED).build();
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

    public Comment to(CreateCommentRequest request) {
        Comment comment = new Comment();
        comment.setHour(request.getHour());
        comment.setTitle(request.getTitle());
        comment.setDescription(request.getDescription());
        return comment;
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
