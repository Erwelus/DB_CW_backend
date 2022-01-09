package com.example.db_cw_backend.controllers;

import com.example.db_cw_backend.model.DeliveryServiceEntity;
import com.example.db_cw_backend.repository.DeliveryServiceRepository;
import com.example.db_cw_backend.service.DeliveryServiceService;
import com.example.db_cw_backend.transfer.DeliveryServiceDto;
import com.example.db_cw_backend.transfer.IdDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/app/delivery_service/")
public class DeliveryServiceController {

    private final DeliveryServiceRepository repository;
    private final DeliveryServiceService service;

    public DeliveryServiceController(DeliveryServiceRepository repository, DeliveryServiceService service){
        this.repository = repository;
        this.service = service;
    }

    @PostMapping("save")
    public ResponseEntity save(@RequestBody DeliveryServiceDto data){
        repository.save(service.prepareEntity(data));
        return ResponseEntity.ok("");
    }

    @GetMapping("all")
    public ResponseEntity getAllQueries(){
        List<DeliveryServiceEntity> entityList = repository.findAll();
        return ResponseEntity.ok(entityList);
    }

    @GetMapping("single")
    public ResponseEntity getById(@RequestBody IdDto data){
        DeliveryServiceEntity entity = repository.findById(data.getId()).get();
        return ResponseEntity.ok(service.prepareDto(entity));
    }

    @PostMapping("delete")
    public ResponseEntity delete(@RequestBody DeliveryServiceDto data){
        repository.deleteById(data.getId());
        return ResponseEntity.ok("");
    }

}
