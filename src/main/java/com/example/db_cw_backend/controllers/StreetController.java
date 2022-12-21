package com.example.db_cw_backend.controllers;

import com.example.db_cw_backend.model.BuildingEntity;
import com.example.db_cw_backend.model.StreetEntity;
import com.example.db_cw_backend.model.StreetStreetEntity;
import com.example.db_cw_backend.repository.QuarterRepository;
import com.example.db_cw_backend.repository.StreetRepository;
import com.example.db_cw_backend.repository.StreetStreetRepository;
import com.example.db_cw_backend.service.StreetService;
import com.example.db_cw_backend.service.StreetStreetService;
import com.example.db_cw_backend.transfer.MaterialBuildingDto;
import com.example.db_cw_backend.transfer.StreetDto;
import com.example.db_cw_backend.transfer.StreetStreetDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/app/street/")
public class StreetController {

    private final StreetRepository repository;
    private final QuarterRepository quarterRepository;
    private final StreetService service;
    private final StreetStreetRepository streetStreetRepository;
    private final StreetStreetService streetStreetService;

    public StreetController(StreetRepository repository, QuarterRepository quarterRepository, StreetService service,
                            StreetStreetRepository streetStreetRepository, StreetStreetService streetStreetService){
        this.repository = repository;
        this.quarterRepository = quarterRepository;
        this.service = service;
        this.streetStreetRepository = streetStreetRepository;
        this.streetStreetService = streetStreetService;
    }

    @PostMapping("save")
    public ResponseEntity save(@RequestBody StreetDto data){
        data.setQuarterId(quarterRepository.findByName(data.getQuarterName()).getId());
        StreetEntity entity = service.prepareEntity(data);
        repository.save(entity);
        streetStreetRepository.deleteAllByStreet1Id(entity.getId());
        streetStreetRepository.deleteAllByStreet2Id(entity.getId());
        for (int i = 0; i < data.getStreetList().size(); i++) {
            StreetStreetDto streetStreetDto = new StreetStreetDto();
            streetStreetDto.setStreet1Id(entity.getId());
            streetStreetDto.setStreet2Id(repository.findByName(data.getStreetList().get(i)).getId());
            streetStreetRepository.save(streetStreetService.prepareEntity(streetStreetDto));
        }
        return ResponseEntity.ok("");
    }

    @PostMapping("update")
    public ResponseEntity update(@RequestBody StreetDto data){
        data.setId(repository.findByName(data.getOldName()).getId());
        return save(data);
    }

    @GetMapping("all")
    public ResponseEntity getAllQueries(){
        List<StreetEntity> entityList = repository.findAll();
        return ResponseEntity.ok(entityList);
    }

    @GetMapping("single")
    public ResponseEntity getByName(@RequestParam String name){
        StreetEntity entity = repository.findByName(name);
        List<StreetStreetEntity> streetStreetEntities = streetStreetRepository.findAllByStreet1Id(entity.getId());
        List<String> streetNameList = new ArrayList<>(streetStreetEntities.size());
        for (StreetStreetEntity current: streetStreetEntities) {
            streetNameList.add(current.getStreet2ByStreet2Id().getName());
        }
        return ResponseEntity.ok(service.prepareDto(entity, streetNameList));
    }

    @PostMapping("delete")
    public ResponseEntity delete(@RequestParam String name){
        repository.deleteByName(name);
        return ResponseEntity.ok("");
    }

    @GetMapping("quarter")
    public ResponseEntity getAllBuildingsOnStreet(@RequestParam String name){
        Integer id = quarterRepository.findByName(name).getId();
        List<StreetEntity> entityList = repository.findAllByQuarterId(id);
        return ResponseEntity.ok(entityList);
    }

}
