package com.example.db_cw_backend.controllers;

import com.example.db_cw_backend.model.RouteEntity;
import com.example.db_cw_backend.model.RouteQuartersEntity;
import com.example.db_cw_backend.model.RouteStreetEntity;
import com.example.db_cw_backend.model.StreetEntity;
import com.example.db_cw_backend.repository.*;
import com.example.db_cw_backend.service.RouteQuartersService;
import com.example.db_cw_backend.service.RouteService;
import com.example.db_cw_backend.service.RouteStreetService;
import com.example.db_cw_backend.transfer.RouteDto;
import com.example.db_cw_backend.transfer.RouteQuartersDto;
import com.example.db_cw_backend.transfer.RouteStreetDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/app/route/")
public class RouteController {

    private final RouteRepository repository;
    private final QuarterRepository quarterRepository;
    private final StreetRepository streetRepository;
    private final RouteQuartersRepository routeQuartersRepository;
    private final RouteStreetRepository routeStreetRepository;
    private final RouteQuartersService quartersService;
    private final RouteStreetService streetService;
    private final RouteService service;

    public RouteController(RouteRepository repository, QuarterRepository quarterRepository,
                           StreetRepository streetRepository, RouteQuartersRepository routeQuartersRepository,
                           RouteStreetRepository routeStreetRepository, RouteQuartersService quartersService,
                           RouteStreetService streetService, RouteService service){
        this.repository = repository;
        this.quarterRepository = quarterRepository;
        this.streetRepository = streetRepository;
        this.routeQuartersRepository = routeQuartersRepository;
        this.routeStreetRepository = routeStreetRepository;
        this.quartersService = quartersService;
        this.streetService = streetService;
        this.service = service;
    }

    @PostMapping("save")
    public ResponseEntity save(@RequestBody RouteDto data){
        RouteEntity entity = service.prepareEntity(data);
        repository.save(entity);

        RouteQuartersDto quartersDto = new RouteQuartersDto();
        quartersDto.setRouteId(entity.getId());
        quartersDto.setQuarterTo(quarterRepository.findByName(data.getQuarterTo()).getId());
        quartersDto.setQuarterFrom(quarterRepository.findByName(data.getQuarterFrom()).getId());
        routeQuartersRepository.save(quartersService.prepareEntity(quartersDto));

        for (String streetName: data.getStreets()) {
            RouteStreetDto streetDto = new RouteStreetDto();
            streetDto.setRouteId(entity.getId());
            streetDto.setStreetId(streetRepository.findByName(streetName).getId());
            routeStreetRepository.save(streetService.prepareEntity(streetDto));
        }
        return ResponseEntity.ok("");
    }

    @PostMapping("update")
    public ResponseEntity update(@RequestBody RouteDto data){
        return save(data);
    }

    @GetMapping("all")
    public ResponseEntity getAllQueries(){
        List<RouteEntity> entityList = repository.findAll();
        return ResponseEntity.ok(entityList);
    }

    @GetMapping("single")
    public ResponseEntity getById(@RequestParam Integer id){
        RouteEntity entity = repository.findById(id).get();
        RouteQuartersEntity quartersEntity = routeQuartersRepository.findByRouteId(id);
        String quarterFrom = quartersEntity.getQuarterByQuarterFrom().getName();
        String quarterTo = quartersEntity.getQuarterByQuarterTo().getName();
        List<RouteStreetEntity> streetList = routeStreetRepository.findAllByRouteId(id);
        List<String> streetNameList = new ArrayList<>(streetList.size());
        for (RouteStreetEntity routeStreetEntity : streetList) {
            streetNameList.add(routeStreetEntity.getStreetByStreetId().getName());
        }
        return ResponseEntity.ok(service.prepareDto(entity, quarterFrom, quarterTo, streetNameList));
    }

    @PostMapping("delete")
    public ResponseEntity delete(@RequestParam Integer id){
        repository.deleteById(id);
        return ResponseEntity.ok("");
    }

}
