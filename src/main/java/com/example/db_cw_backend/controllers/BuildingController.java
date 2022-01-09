package com.example.db_cw_backend.controllers;

import com.example.db_cw_backend.model.BuildingEntity;
import com.example.db_cw_backend.repository.BuildingRepository;
import com.example.db_cw_backend.service.BuildingService;
import com.example.db_cw_backend.transfer.IdDto;
import com.example.db_cw_backend.transfer.BuildingDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/app/building/")
public class BuildingController {

    private final BuildingRepository repository;
    private final BuildingService service;

    public BuildingController(BuildingRepository repository, BuildingService service){
        this.repository = repository;
        this.service = service;
    }

    @PostMapping("save")
    public ResponseEntity save(@RequestBody BuildingDto data){
        repository.save(service.prepareEntity(data));
        return ResponseEntity.ok("");
    }

    @GetMapping("all")
    public ResponseEntity getAllQueries(){
        List<BuildingEntity> entityList = repository.findAll();
        return ResponseEntity.ok(entityList);
    }

    @GetMapping("single")
    public ResponseEntity getById(@RequestBody IdDto data){
        BuildingEntity entity = repository.findById(data.getId()).get();
        return ResponseEntity.ok(service.prepareDto(entity));
    }

    @PostMapping("delete")
    public ResponseEntity delete(@RequestBody BuildingDto data){
        repository.deleteById(data.getId());
        return ResponseEntity.ok("");
    }

    @GetMapping("cost")
    public ResponseEntity getCost(@RequestBody IdDto data){
        return ResponseEntity.ok(repository.countBuildingCost(data.getId()));
    }

    @GetMapping("street")
    public ResponseEntity getAllBuildingsOnStreet(@RequestBody IdDto data){
        List<BuildingEntity> entityList = repository.findAllByStreetId(data.getId());
        return ResponseEntity.ok(entityList);
    }

}
