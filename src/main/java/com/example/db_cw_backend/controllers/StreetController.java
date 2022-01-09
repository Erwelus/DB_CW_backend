package com.example.db_cw_backend.controllers;

import com.example.db_cw_backend.model.StreetEntity;
import com.example.db_cw_backend.repository.StreetRepository;
import com.example.db_cw_backend.service.StreetService;
import com.example.db_cw_backend.transfer.StreetDto;
import com.example.db_cw_backend.transfer.IdDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/app/street/")
public class StreetController {

    private final StreetRepository repository;
    private final StreetService service;

    public StreetController(StreetRepository repository, StreetService service){
        this.repository = repository;
        this.service = service;
    }

    @PostMapping("save")
    public ResponseEntity save(@RequestBody StreetDto data){
        repository.save(service.prepareEntity(data));
        return ResponseEntity.ok("");
    }

    @GetMapping("all")
    public ResponseEntity getAllQueries(){
        List<StreetEntity> entityList = repository.findAll();
        return ResponseEntity.ok(entityList);
    }

    @GetMapping("single")
    public ResponseEntity getById(@RequestBody IdDto data){
        StreetEntity entity = repository.findById(data.getId()).get();
        return ResponseEntity.ok(service.prepareDto(entity));
    }

    @PostMapping("delete")
    public ResponseEntity delete(@RequestBody StreetDto data){
        repository.deleteById(data.getId());
        return ResponseEntity.ok("");
    }

    @GetMapping("quarter")
    public ResponseEntity getAllBuildingsOnStreet(@RequestBody IdDto data){
        List<StreetEntity> entityList = repository.findAllByQuarterId(data.getId());
        return ResponseEntity.ok(entityList);
    }

}
