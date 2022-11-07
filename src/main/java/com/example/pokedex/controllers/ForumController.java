package com.example.pokedex.controllers;

import com.example.pokedex.controllers.dtos.request.CreateForumRequest;
import com.example.pokedex.controllers.dtos.request.UpdateForumRequest;
import com.example.pokedex.controllers.dtos.response.*;
import com.example.pokedex.services.interfaces.IForumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("forum")
public class ForumController {
    @Autowired
    private IForumService service;

    @GetMapping("{id}")
    public GetForumResponse get(@PathVariable Long id){
        return service.get(id);
    }

    @PostMapping
    public ResponseEntity<BaseResponse> Create(@RequestBody @Valid CreateForumRequest request){
        BaseResponse baseResponse = service.create(request);
        return new ResponseEntity<>(baseResponse,baseResponse.getHttpStatus());
    }

    @PutMapping("{id}")
    public UpdateForumResponse update(@RequestBody UpdateForumRequest request, @PathVariable Long id){
        return service.update(request, id);
    }

    @GetMapping
    public List<GetForumResponse> list(){
        return service.list();
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }

}
