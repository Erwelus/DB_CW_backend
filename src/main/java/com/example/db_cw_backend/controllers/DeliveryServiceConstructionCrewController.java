package com.example.db_cw_backend.controllers;

import com.example.db_cw_backend.model.DeliveryServiceConstructionCrewEntity;
import com.example.db_cw_backend.repository.DeliveryServiceConstructionCrewRepository;
import com.example.db_cw_backend.service.DeliveryServiceConstructionCrewService;
import com.example.db_cw_backend.transfer.DeliveryServiceConstructionCrewDto;
import com.example.db_cw_backend.transfer.IdDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/app/delivery_service_construction_crew/")
public class DeliveryServiceConstructionCrewController {

    private final DeliveryServiceConstructionCrewRepository repository;
    private final DeliveryServiceConstructionCrewService service;

    public DeliveryServiceConstructionCrewController(DeliveryServiceConstructionCrewRepository repository, DeliveryServiceConstructionCrewService service){
        this.repository = repository;
        this.service = service;
    }

    @PostMapping("save")
    public ResponseEntity save(@RequestBody DeliveryServiceConstructionCrewDto data){
        repository.save(service.prepareEntity(data));
        return ResponseEntity.ok("");
    }

    @GetMapping("all")
    public ResponseEntity getAllQueries(){
        List<DeliveryServiceConstructionCrewEntity> entityList = repository.findAll();
        return ResponseEntity.ok(entityList);
    }

    @GetMapping("single")
    public ResponseEntity getById(@RequestBody IdDto data){
        DeliveryServiceConstructionCrewEntity entity = repository.findById(data.getId()).get();
        return ResponseEntity.ok(service.prepareDto(entity));
    }

    @PostMapping("delete")
    public ResponseEntity delete(@RequestBody DeliveryServiceConstructionCrewDto data){
        repository.delete(service.prepareEntity(data));
        return ResponseEntity.ok("");
    }

}
