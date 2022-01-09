package com.example.db_cw_backend.controllers;

import com.example.db_cw_backend.model.ConstructionCrewEntity;
import com.example.db_cw_backend.repository.ConstructionCrewRepository;
import com.example.db_cw_backend.service.ConstructionCrewService;
import com.example.db_cw_backend.transfer.ConstructionCrewDto;
import com.example.db_cw_backend.transfer.IdDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/app/construction_crew/")
public class ConstructionCrewController {

    private final ConstructionCrewRepository repository;
    private final ConstructionCrewService service;

    public ConstructionCrewController(ConstructionCrewRepository repository, ConstructionCrewService service){
        this.repository = repository;
        this.service = service;
    }

    @PostMapping("save")
    public ResponseEntity save(@RequestBody ConstructionCrewDto data){
        repository.save(service.prepareEntity(data));
        return ResponseEntity.ok("");
    }

    @GetMapping("all")
    public ResponseEntity getAllQueries(){
        List<ConstructionCrewEntity> entityList = repository.findAll();
        return ResponseEntity.ok(entityList);
    }

    @GetMapping("single")
    public ResponseEntity getById(@RequestBody IdDto data){
        ConstructionCrewEntity entity = repository.findById(data.getId()).get();
        return ResponseEntity.ok(service.prepareDto(entity));
    }

    @PostMapping("delete")
    public ResponseEntity delete(@RequestBody ConstructionCrewDto data){
        repository.deleteById(data.getId());
        return ResponseEntity.ok("");
    }

}
