package com.example.db_cw_backend.controllers;

import com.example.db_cw_backend.model.BuildingEntity;
import com.example.db_cw_backend.model.CityServiceBuildingEntity;
import com.example.db_cw_backend.model.MaterialBuildingEntity;
import com.example.db_cw_backend.repository.*;
import com.example.db_cw_backend.service.BuildingService;
import com.example.db_cw_backend.service.CityServiceBuildingService;
import com.example.db_cw_backend.service.MaterialBuildingService;
import com.example.db_cw_backend.transfer.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/app/building/")
public class BuildingController {

    private final BuildingRepository repository;
    private final BuildingService service;
    private final CityServiceBuildingRepository serviceBuildingRepository;
    private final MaterialBuildingRepository materialBuildingRepository;
    private final CityServiceBuildingService serviceBuildingService;
    private final MaterialBuildingService materialBuildingService;
    private final CityServiceRepository serviceRepository;
    private final MaterialRepository materialRepository;
    private final StreetRepository streetRepository;

    public BuildingController(BuildingRepository repository, BuildingService service,
                              CityServiceBuildingRepository serviceBuildingRepository,
                              MaterialBuildingRepository materialBuildingRepository,
                              CityServiceBuildingService serviceBuildingService,
                              MaterialBuildingService materialBuildingService,
                              CityServiceRepository serviceRepository,
                              MaterialRepository materialRepository,
                              StreetRepository streetRepository){
        this.repository = repository;
        this.service = service;
        this.serviceBuildingRepository = serviceBuildingRepository;
        this.materialBuildingRepository = materialBuildingRepository;
        this.serviceBuildingService = serviceBuildingService;
        this.materialBuildingService = materialBuildingService;
        this.serviceRepository = serviceRepository;
        this.materialRepository = materialRepository;
        this.streetRepository = streetRepository;
    }

    @PostMapping("save")
    public ResponseEntity save(@RequestBody BuildingDto data){
        data.setStreetId(streetRepository.findByName(data.getStreetName()).getId());
        BuildingEntity entity = service.prepareEntity(data);
        repository.save(entity);

        for (int i = 0; i < data.getMaterialList().size(); i++) {
            MaterialBuildingDto materialBuildingDto = new MaterialBuildingDto();
            materialBuildingDto.setBuildingId(entity.getId());
            materialBuildingDto.setMaterialId(materialRepository.findByType(data.getMaterialList().get(i)).getId());
            materialBuildingDto.setQuantity(data.getQuantityList().get(i));
            materialBuildingRepository.save(materialBuildingService.prepareEntity(materialBuildingDto));
        }

        for (String type: data.getServiceList()) {
            CityServiceBuildingDto cityServiceBuildingDto = new CityServiceBuildingDto();
            cityServiceBuildingDto.setBuildingId(entity.getId());
            cityServiceBuildingDto.setServiceId(serviceRepository.findByType(type).getId());
            serviceBuildingRepository.save(serviceBuildingService.prepareEntity(cityServiceBuildingDto));
        }

        return ResponseEntity.ok("");
    }

    @PostMapping("update")
    public ResponseEntity update(@RequestBody BuildingDto data){
        data.setId(repository.findByName(data.getName()).getId());
        return save(data);
    }

    @GetMapping("all")
    public ResponseEntity getAllQueries(){
        List<BuildingEntity> entityList = repository.findAll();
        return ResponseEntity.ok(entityList);
    }

    @GetMapping("single")
    public ResponseEntity getByName(@RequestParam String name){
        BuildingEntity entity = repository.findByName(name);
        List<MaterialBuildingEntity> materialList = materialBuildingRepository.findAllByBuildingId(entity.getId());

        List<String> materialTypeList = new ArrayList<>(materialList.size());
        for (MaterialBuildingEntity materialBuildingEntity : materialList) {
            materialTypeList.add(materialBuildingEntity.getMaterialByMaterialId().getType());
        }

        List<Integer> quantityList = new ArrayList<>(materialList.size());
        for (MaterialBuildingEntity materialBuildingEntity : materialList) {
            quantityList.add(materialBuildingEntity.getMaterialByMaterialId().getQuantity());
        }

        List<CityServiceBuildingEntity> serviceList = serviceBuildingRepository.findAllByBuildingId(entity.getId());
        List<String> serviceTypeList = new ArrayList<>(serviceList.size());
        for (CityServiceBuildingEntity serviceBuildingEntity : serviceList) {
            serviceTypeList.add(serviceBuildingEntity.getCityServiceByServiceId().getType());
        }
        return ResponseEntity.ok(service.prepareDto(entity, materialTypeList, quantityList, serviceTypeList));
    }

    @PostMapping("delete")
    public ResponseEntity delete(@RequestParam String name){
        repository.deleteByName(name);
        return ResponseEntity.ok("");
    }

    @GetMapping("cost")
    public ResponseEntity getCost(@RequestParam String name){
        Integer id = repository.findByName(name).getId();
        return ResponseEntity.ok(repository.countBuildingCost(id));
    }

    @GetMapping("street")
    public ResponseEntity getAllBuildingsOnStreet(@RequestParam String name){
        Integer id = streetRepository.findByName(name).getId();
        List<BuildingEntity> entityList = repository.findAllByStreetId(id);
        return ResponseEntity.ok(entityList);
    }

}
