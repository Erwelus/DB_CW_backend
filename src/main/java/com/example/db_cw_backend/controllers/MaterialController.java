package com.example.db_cw_backend.controllers;

import com.example.db_cw_backend.model.MaterialEntity;
import com.example.db_cw_backend.repository.MaterialRepository;
import com.example.db_cw_backend.service.MaterialService;
import com.example.db_cw_backend.transfer.MaterialDto;
import com.example.db_cw_backend.transfer.IdDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/app/material/")
public class MaterialController {

    private final MaterialRepository repository;
    private final MaterialService service;

    public MaterialController(MaterialRepository repository, MaterialService service){
        this.repository = repository;
        this.service = service;
    }

    @PostMapping("save")
    public ResponseEntity save(@RequestBody MaterialDto data){
        repository.save(service.prepareEntity(data));
        return ResponseEntity.ok("");
    }

    @GetMapping("all")
    public ResponseEntity getAllQueries(){
        List<MaterialEntity> entityList = repository.findAll();
        return ResponseEntity.ok(entityList);
    }

    @GetMapping("single")
    public ResponseEntity getById(@RequestBody IdDto data){
        MaterialEntity entity = repository.findById(data.getId()).get();
        return ResponseEntity.ok(service.prepareDto(entity));
    }

    @PostMapping("delete")
    public ResponseEntity delete(@RequestBody MaterialDto data){
        repository.deleteById(data.getId());
        return ResponseEntity.ok("");
    }

}