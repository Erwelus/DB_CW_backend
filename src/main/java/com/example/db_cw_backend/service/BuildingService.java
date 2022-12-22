package com.example.db_cw_backend.service;

import com.example.db_cw_backend.model.BuildingEntity;
import com.example.db_cw_backend.model.CityServiceEntity;
import com.example.db_cw_backend.model.QuarterEntity;
import com.example.db_cw_backend.repository.BuildingRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Objects;

@Service
public class BuildingService {
    private final BuildingRepository repository;

    public BuildingService(BuildingRepository repository) {
        this.repository = repository;
    }

    public List<BuildingEntity> findAll(Long streetId) {
        return repository.findAllByStreetId(streetId);
    }

    public BuildingEntity findById(Long id, Long streetId) {
        BuildingEntity entity = repository.findById(id).orElseThrow(EntityNotFoundException::new);
        if (!Objects.equals(entity.getStreet().getId(), streetId)) throw new IllegalArgumentException();
        return entity;
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public void save(BuildingEntity building) {
        repository.save(building);
    }

    public Double calculateCost(BuildingEntity building) {
        Double materialCost = building.getMaterials().stream().mapToDouble(materialInBuilding -> {
            return materialInBuilding.getMaterial().getPrice() * materialInBuilding.getQuantity();
        }).sum();
        Double serviceCost = building.getServices().stream().mapToDouble(CityServiceEntity::getPrice).sum();
        return materialCost + serviceCost;
    }
}
