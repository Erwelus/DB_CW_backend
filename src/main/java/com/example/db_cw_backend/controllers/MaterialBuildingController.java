package com.example.db_cw_backend.controllers;

import com.example.db_cw_backend.model.BuildingEntity;
import com.example.db_cw_backend.model.MaterialBuildingEntity;
import com.example.db_cw_backend.model.MaterialEntity;
import com.example.db_cw_backend.repository.MaterialBuildingRepository;
import com.example.db_cw_backend.service.MaterialBuildingService;
import com.example.db_cw_backend.transfer.MaterialBuildingDto;
import com.example.db_cw_backend.transfer.IdDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/app/material_building/")
public class MaterialBuildingController {

    private final MaterialBuildingRepository repository;
    private final MaterialBuildingService service;

    public MaterialBuildingController(MaterialBuildingRepository repository, MaterialBuildingService service){
        this.repository = repository;
        this.service = service;
    }

    @PostMapping("save")
    public ResponseEntity save(@RequestBody MaterialBuildingDto data){
        repository.save(service.prepareEntity(data));
        return ResponseEntity.ok("");
    }

    @GetMapping("all")
    public ResponseEntity getAllQueries(){
        List<MaterialBuildingEntity> entityList = repository.findAll();
        return ResponseEntity.ok(entityList);
    }

    @GetMapping("single")
    public ResponseEntity getById(@RequestParam Integer id){
        MaterialBuildingEntity entity = repository.findById(id).get();
        return ResponseEntity.ok(service.prepareDto(entity));
    }

    @PostMapping("delete")
    public ResponseEntity delete(@RequestBody MaterialBuildingDto data){
        repository.delete(service.prepareEntity(data));
        return ResponseEntity.ok("");
    }
}