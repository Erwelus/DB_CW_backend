package com.example.db_cw_backend.controllers;

import com.example.db_cw_backend.model.RouteQuartersEntity;
import com.example.db_cw_backend.repository.RouteQuartersRepository;
import com.example.db_cw_backend.service.RouteQuartersService;
import com.example.db_cw_backend.transfer.RouteQuartersDto;
import com.example.db_cw_backend.transfer.IdDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/app/route_quarters/")
public class RouteQuartersController {

    private final RouteQuartersRepository repository;
    private final RouteQuartersService service;

    public RouteQuartersController(RouteQuartersRepository repository, RouteQuartersService service){
        this.repository = repository;
        this.service = service;
    }

    @PostMapping("save")
    public ResponseEntity save(@RequestBody RouteQuartersDto data){
        repository.save(service.prepareEntity(data));
        return ResponseEntity.ok("");
    }

    @GetMapping("all")
    public ResponseEntity getAllQueries(){
        List<RouteQuartersEntity> entityList = repository.findAll();
        return ResponseEntity.ok(entityList);
    }

    @GetMapping("single")
    public ResponseEntity getById(@RequestBody IdDto data){
        RouteQuartersEntity entity = repository.findById(data.getId()).get();
        return ResponseEntity.ok(service.prepareDto(entity));
    }

    @PostMapping("delete")
    public ResponseEntity delete(@RequestBody RouteQuartersDto data){
        repository.delete(service.prepareEntity(data));
        return ResponseEntity.ok("");
    }
}
