package com.example.db_cw_backend.controllers;

import com.example.db_cw_backend.model.BuildingEntity;
import com.example.db_cw_backend.model.RouteStreetEntity;
import com.example.db_cw_backend.repository.RouteStreetRepository;
import com.example.db_cw_backend.service.RouteStreetService;
import com.example.db_cw_backend.transfer.RouteStreetDto;
import com.example.db_cw_backend.transfer.IdDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/app/route_street/")
public class RouteStreetController {

    private final RouteStreetRepository repository;
    private final RouteStreetService service;

    public RouteStreetController(RouteStreetRepository repository, RouteStreetService service){
        this.repository = repository;
        this.service = service;
    }

    @PostMapping("save")
    public ResponseEntity save(@RequestBody RouteStreetDto data){
        repository.save(service.prepareEntity(data));
        return ResponseEntity.ok("");
    }

    @GetMapping("all")
    public ResponseEntity getAllQueries(){
        List<RouteStreetEntity> entityList = repository.findAll();
        return ResponseEntity.ok(entityList);
    }

    @GetMapping("single")
    public ResponseEntity getById(@RequestParam Integer id){
        RouteStreetEntity entity = repository.findById(id).get();
        return ResponseEntity.ok(service.prepareDto(entity));
    }

    @PostMapping("delete")
    public ResponseEntity delete(@RequestBody RouteStreetDto data){
        repository.delete(service.prepareEntity(data));
        return ResponseEntity.ok("");
    }
}
