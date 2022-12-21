package com.example.db_cw_backend.controllers;

import com.example.db_cw_backend.model.CityServiceEntity;
import com.example.db_cw_backend.model.ServiceTeamEntity;
import com.example.db_cw_backend.repository.CityServiceRepository;
import com.example.db_cw_backend.repository.QuarterRepository;
import com.example.db_cw_backend.repository.ServiceTeamRepository;
import com.example.db_cw_backend.service.CityServiceService;
import com.example.db_cw_backend.transfer.CityServiceDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/app/city_service/")
public class CityServiceController {

    private final CityServiceRepository repository;
    private final QuarterRepository quarterRepository;
    private final ServiceTeamRepository serviceTeamRepository;
    private final CityServiceService service;

    public CityServiceController(CityServiceRepository repository, QuarterRepository quarterRepository,
                                 ServiceTeamRepository serviceTeamRepository, CityServiceService service){
        this.repository = repository;
        this.quarterRepository = quarterRepository;
        this.serviceTeamRepository = serviceTeamRepository;
        this.service = service;
    }

    @PostMapping("save")
    public ResponseEntity save(@RequestBody CityServiceDto data){
        repository.save(service.prepareEntity(data));
        return ResponseEntity.ok("");
    }

    @PostMapping("update")
    public ResponseEntity update(@RequestBody CityServiceDto data){
        return save(data);
    }

    @GetMapping("all")
    public ResponseEntity getAllQueries(){
        List<CityServiceEntity> entityList = repository.findAll();
        return ResponseEntity.ok(entityList);
    }

    @GetMapping("quarter")
    public ResponseEntity getAllQueriesInQuarter(@RequestParam String name){
        Integer id = quarterRepository.findByName(name).getId();
        List<ServiceTeamEntity> teamList = serviceTeamRepository.findAllByQuarterId(id);
        List<CityServiceEntity> entityList = new ArrayList<>(teamList.size());
        for (ServiceTeamEntity current: teamList) {
            entityList.add(current.getCityServiceByServiceId());
        }
        return ResponseEntity.ok(entityList);
    }

    @GetMapping("single")
    public ResponseEntity getById(@RequestParam String type){
        CityServiceEntity entity = repository.findByType(type);
        return ResponseEntity.ok(service.prepareDto(entity));
    }

    @PostMapping("delete")
    public ResponseEntity delete(@RequestParam String type){
        repository.deleteByType(type);
        return ResponseEntity.ok("");
    }

}
