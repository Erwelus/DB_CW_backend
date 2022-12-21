package com.example.db_cw_backend.controllers;

import com.example.db_cw_backend.model.ConstructionCrewEntity;
import com.example.db_cw_backend.repository.ConstructionCrewRepository;
import com.example.db_cw_backend.service.ConstructionCrewService;
import com.example.db_cw_backend.transfer.CityServiceDto;
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

    @PostMapping("update")
    public ResponseEntity update(@RequestBody ConstructionCrewDto data){
        return save(data);
    }

    @GetMapping("all")
    public ResponseEntity getAllQueries(){
        List<ConstructionCrewEntity> entityList = repository.findAll();
        return ResponseEntity.ok(entityList);
    }

    @GetMapping("single")
    public ResponseEntity getById(@RequestParam Integer id){
        ConstructionCrewEntity entity = repository.findById(id).get();
        return ResponseEntity.ok(service.prepareDto(entity));
    }

    @PostMapping("delete")
    public ResponseEntity delete(@RequestParam Integer id){
        repository.deleteById(id);
        return ResponseEntity.ok("");
    }

}
