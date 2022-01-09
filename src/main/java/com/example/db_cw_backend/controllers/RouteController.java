package com.example.db_cw_backend.controllers;

import com.example.db_cw_backend.model.RouteEntity;
import com.example.db_cw_backend.repository.RouteRepository;
import com.example.db_cw_backend.service.RouteService;
import com.example.db_cw_backend.transfer.RouteDto;
import com.example.db_cw_backend.transfer.IdDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/app/route/")
public class RouteController {

    private final RouteRepository repository;
    private final RouteService service;

    public RouteController(RouteRepository repository, RouteService service){
        this.repository = repository;
        this.service = service;
    }

    @PostMapping("save")
    public ResponseEntity save(@RequestBody RouteDto data){
        repository.save(service.prepareEntity(data));
        return ResponseEntity.ok("");
    }

    @GetMapping("all")
    public ResponseEntity getAllQueries(){
        List<RouteEntity> entityList = repository.findAll();
        return ResponseEntity.ok(entityList);
    }

    @GetMapping("single")
    public ResponseEntity getById(@RequestBody IdDto data){
        RouteEntity entity = repository.findById(data.getId()).get();
        return ResponseEntity.ok(service.prepareDto(entity));
    }

    @PostMapping("delete")
    public ResponseEntity delete(@RequestBody RouteDto data){
        repository.deleteById(data.getId());
        return ResponseEntity.ok("");
    }

}
