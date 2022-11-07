package com.example.pokedex.controllers;

import com.example.pokedex.controllers.dtos.request.CreateTipsRequest;
import com.example.pokedex.controllers.dtos.request.UpdateTipsRequest;
import com.example.pokedex.controllers.dtos.response.*;
import com.example.pokedex.services.interfaces.ITipsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("tips")
public class TipsController {
    @Autowired
    private ITipsService service;

    @GetMapping("{id}")
    public GetTipsResponse get(@PathVariable Long id) {
        return service.get(id);
    }

    @PostMapping
    public ResponseEntity<BaseResponse> Create(@RequestBody CreateTipsRequest request) {
        BaseResponse baseResponse = service.create(request);
        return new ResponseEntity<>(baseResponse,baseResponse.getHttpStatus());
    }

    @PutMapping("{id}")
    public UpdateTipsResponse update(@RequestBody UpdateTipsRequest request, @PathVariable Long id) {
        return service.update(request, id);
    }

    @GetMapping
    public List<GetTipsResponse> list() {
        return service.list();
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @GetMapping("tips/trainers/{trainersId}")
    public List<TipsResponse> listAllTipsByTrainersId(@PathVariable Long trainersId) {
        return service.listAllTipsByTrainersId(trainersId);
    }
}
