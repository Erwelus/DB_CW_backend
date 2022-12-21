package com.example.db_cw_backend.controllers;

import com.example.db_cw_backend.model.DeliveryServiceEntity;
import com.example.db_cw_backend.repository.DeliveryServiceRepository;
import com.example.db_cw_backend.repository.MaterialRepository;
import com.example.db_cw_backend.service.DeliveryServiceService;
import com.example.db_cw_backend.transfer.CityServiceDto;
import com.example.db_cw_backend.transfer.DeliveryServiceDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/app/delivery_service/")
public class DeliveryServiceController {

    private final DeliveryServiceRepository repository;
    private final DeliveryServiceService service;
    private final MaterialRepository materialRepository;

    public DeliveryServiceController(DeliveryServiceRepository repository, DeliveryServiceService service, MaterialRepository materialRepository){
        this.repository = repository;
        this.service = service;
        this.materialRepository = materialRepository;
    }

    @PostMapping("update")
    public ResponseEntity update(@RequestBody DeliveryServiceDto data){
        data.setId(repository.findByName(data.getName()).getId());
        data.setMaterialId(materialRepository.findByType(data.getMaterialType()).getId());
        repository.save(service.prepareEntity(data));
        return ResponseEntity.ok("");
    }

    @PostMapping("save")
    public ResponseEntity save(@RequestBody DeliveryServiceDto data){
        data.setMaterialId(materialRepository.findByType(data.getMaterialType()).getId());
        repository.save(service.prepareEntity(data));
        return ResponseEntity.ok("");
    }

    @GetMapping("all")
    public ResponseEntity getAllQueries(){
        List<DeliveryServiceEntity> entityList = repository.findAll();
        return ResponseEntity.ok(entityList);
    }

    @GetMapping("single")
    public ResponseEntity getByName(@RequestParam String name){
        DeliveryServiceEntity entity = repository.findByName(name);
        return ResponseEntity.ok(service.prepareDto(entity));
    }

    @PostMapping("delete")
    public ResponseEntity delete(@RequestParam String name){
        repository.deleteByName(name);
        return ResponseEntity.ok("");
    }

}
