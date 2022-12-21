package com.example.db_cw_backend.controllers;

import com.example.db_cw_backend.model.BuildingEntity;
import com.example.db_cw_backend.model.CommitteeEntity;
import com.example.db_cw_backend.repository.CommitteeRepository;
import com.example.db_cw_backend.service.CommitteeService;
import com.example.db_cw_backend.transfer.CityServiceDto;
import com.example.db_cw_backend.transfer.CommitteeDto;
import com.example.db_cw_backend.transfer.IdDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/app/committee/")
public class CommitteeController {

    private final CommitteeRepository repository;
    private final CommitteeService service;

    public CommitteeController(CommitteeRepository repository, CommitteeService service){
        this.repository = repository;
        this.service = service;
    }

    @PostMapping("save")
    public ResponseEntity save(@RequestBody CommitteeDto data){
        repository.save(service.prepareEntity(data));
        return ResponseEntity.ok("");
    }

    @PostMapping("update")
    public ResponseEntity update(@RequestBody CommitteeDto data){
        return save(data);
    }

    @GetMapping("all")
    public ResponseEntity getAllQueries(){
        List<CommitteeEntity> entityList = repository.findAll();
        return ResponseEntity.ok(entityList);
    }

    @GetMapping("single")
    public ResponseEntity getById(@RequestParam Integer id){
        CommitteeEntity entity = repository.findById(id).get();
        return ResponseEntity.ok(service.prepareDto(entity));
    }

    @PostMapping("delete")
    public ResponseEntity delete(@RequestParam Integer id){
        repository.deleteById(id);
        return ResponseEntity.ok("");
    }

    @GetMapping("accept")
    public ResponseEntity accept(@RequestParam Integer id){
        return ResponseEntity.ok(repository.acceptReadyBuildingsForCommittee(id));
    }

}