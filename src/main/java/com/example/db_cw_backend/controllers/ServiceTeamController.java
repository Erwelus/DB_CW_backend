package com.example.db_cw_backend.controllers;

import com.example.db_cw_backend.model.ServiceTeamEntity;
import com.example.db_cw_backend.repository.CityServiceRepository;
import com.example.db_cw_backend.repository.MaterialRepository;
import com.example.db_cw_backend.repository.QuarterRepository;
import com.example.db_cw_backend.repository.ServiceTeamRepository;
import com.example.db_cw_backend.service.ServiceTeamService;
import com.example.db_cw_backend.transfer.RouteDto;
import com.example.db_cw_backend.transfer.ServiceTeamDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/app/service_team/")
public class ServiceTeamController {

    private final ServiceTeamRepository repository;
    private final ServiceTeamService service;
    private final QuarterRepository quarterRepository;
    private final CityServiceRepository serviceRepository;

    public ServiceTeamController(ServiceTeamRepository repository, ServiceTeamService service,
                                 QuarterRepository quarterRepository, CityServiceRepository serviceRepository){
        this.repository = repository;
        this.service = service;
        this.quarterRepository = quarterRepository;
        this.serviceRepository = serviceRepository;
    }

    @PostMapping("save")
    public ResponseEntity save(@RequestBody ServiceTeamDto data){
        data.setCityServiceId(serviceRepository.findByType(data.getServiceType()).getId());
        data.setQuarterId(quarterRepository.findByName(data.getQuarterName()).getId());
        repository.save(service.prepareEntity(data));
        return ResponseEntity.ok("");
    }

    @PostMapping("update")
    public ResponseEntity update(@RequestBody ServiceTeamDto data){
        return save(data);
    }

    @GetMapping("all")
    public ResponseEntity getAllQueries(){
        List<ServiceTeamEntity> entityList = repository.findAll();
        return ResponseEntity.ok(entityList);
    }

    @GetMapping("single")
    public ResponseEntity getById(@RequestParam Integer id){
        ServiceTeamEntity entity = repository.findById(id).get();
        return ResponseEntity.ok(service.prepareDto(entity));
    }

    @PostMapping("delete")
    public ResponseEntity delete(@RequestParam Integer id){
        repository.deleteById(id);
        return ResponseEntity.ok("");
    }

}