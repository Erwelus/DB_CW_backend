package com.example.db_cw_backend.controllers;

import com.example.db_cw_backend.model.CommitteeEntity;
import com.example.db_cw_backend.repository.CommitteeRepository;
import com.example.db_cw_backend.service.CommitteeService;
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

    @GetMapping("all")
    public ResponseEntity getAllQueries(){
        List<CommitteeEntity> entityList = repository.findAll();
        return ResponseEntity.ok(entityList);
    }

    @GetMapping("single")
    public ResponseEntity getById(@RequestBody IdDto data){
        CommitteeEntity entity = repository.findById(data.getId()).get();
        return ResponseEntity.ok(service.prepareDto(entity));
    }

    @PostMapping("delete")
    public ResponseEntity delete(@RequestBody CommitteeDto data){
        repository.deleteById(data.getId());
        return ResponseEntity.ok("");
    }

    @PostMapping("accept")
    public ResponseEntity delete(@RequestBody IdDto data){
        repository.acceptReadyBuildingsForCommittee(data.getId());
        return ResponseEntity.ok("");
    }

}