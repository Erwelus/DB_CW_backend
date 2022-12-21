package com.example.db_cw_backend.controllers;

import com.example.db_cw_backend.model.BuildingEntity;
import com.example.db_cw_backend.model.CityServiceBuildingEntity;
import com.example.db_cw_backend.model.QuarterEntity;
import com.example.db_cw_backend.repository.CityServiceBuildingRepository;
import com.example.db_cw_backend.repository.QuarterRepository;
import com.example.db_cw_backend.service.CityServiceBuildingService;
import com.example.db_cw_backend.service.QuarterService;
import com.example.db_cw_backend.transfer.CityServiceBuildingDto;
import com.example.db_cw_backend.transfer.IdDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/app/city_service_building/")
public class CityServiceBuildingController {

    private final CityServiceBuildingRepository repository;
    private final CityServiceBuildingService service;

    public CityServiceBuildingController(CityServiceBuildingRepository repository, CityServiceBuildingService service){
        this.repository = repository;
        this.service = service;
    }

    @PostMapping("save")
    public ResponseEntity save(@RequestBody CityServiceBuildingDto data){
        repository.save(service.prepareEntity(data));
        return ResponseEntity.ok("");
    }

    @GetMapping("all")
    public ResponseEntity getAllQueries(){
        List<CityServiceBuildingEntity> entityList = repository.findAll();
        return ResponseEntity.ok(entityList);
    }

    @GetMapping("single")
    public ResponseEntity getById(@RequestParam Integer id){
        CityServiceBuildingEntity entity = repository.findById(id).get();
        return ResponseEntity.ok(service.prepareDto(entity));
    }

    @PostMapping("delete")
    public ResponseEntity delete(@RequestBody CityServiceBuildingDto data){
        repository.delete(service.prepareEntity(data));
        return ResponseEntity.ok("");
    }
}
