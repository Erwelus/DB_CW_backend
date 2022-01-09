package com.example.db_cw_backend.controllers;

import com.example.db_cw_backend.model.ServiceTeamEntity;
import com.example.db_cw_backend.repository.ServiceTeamRepository;
import com.example.db_cw_backend.service.ServiceTeamService;
import com.example.db_cw_backend.transfer.ServiceTeamDto;
import com.example.db_cw_backend.transfer.IdDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/app/service_team/")
public class ServiceTeamController {

    private final ServiceTeamRepository repository;
    private final ServiceTeamService service;

    public ServiceTeamController(ServiceTeamRepository repository, ServiceTeamService service){
        this.repository = repository;
        this.service = service;
    }

    @PostMapping("save")
    public ResponseEntity save(@RequestBody ServiceTeamDto data){
        repository.save(service.prepareEntity(data));
        return ResponseEntity.ok("");
    }

    @GetMapping("all")
    public ResponseEntity getAllQueries(){
        List<ServiceTeamEntity> entityList = repository.findAll();
        return ResponseEntity.ok(entityList);
    }

    @GetMapping("single")
    public ResponseEntity getById(@RequestBody IdDto data){
        ServiceTeamEntity entity = repository.findById(data.getId()).get();
        return ResponseEntity.ok(service.prepareDto(entity));
    }

    @PostMapping("delete")
    public ResponseEntity delete(@RequestBody ServiceTeamDto data){
        repository.deleteById(data.getId());
        return ResponseEntity.ok("");
    }

}