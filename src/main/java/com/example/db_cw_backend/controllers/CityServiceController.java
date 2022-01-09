package com.example.db_cw_backend.controllers;

import com.example.db_cw_backend.model.CityServiceEntity;
import com.example.db_cw_backend.repository.CityServiceRepository;
import com.example.db_cw_backend.service.CityServiceService;
import com.example.db_cw_backend.transfer.CityServiceDto;
import com.example.db_cw_backend.transfer.IdDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/app/city_service/")
public class CityServiceController {

    private final CityServiceRepository repository;
    private final CityServiceService service;

    public CityServiceController(CityServiceRepository repository, CityServiceService service){
        this.repository = repository;
        this.service = service;
    }

    @PostMapping("save")
    public ResponseEntity save(@RequestBody CityServiceDto data){
        repository.save(service.prepareEntity(data));
        return ResponseEntity.ok("");
    }

    @GetMapping("all")
    public ResponseEntity getAllQueries(){
        List<CityServiceEntity> entityList = repository.findAll();
        return ResponseEntity.ok(entityList);
    }

    @GetMapping("single")
    public ResponseEntity getById(@RequestBody IdDto data){
        CityServiceEntity entity = repository.findById(data.getId()).get();
        return ResponseEntity.ok(service.prepareDto(entity));
    }

    @PostMapping("delete")
    public ResponseEntity delete(@RequestBody CityServiceDto data){
        repository.deleteById(data.getId());
        return ResponseEntity.ok("");
    }

}
