package com.example.db_cw_backend.repository;

import com.example.db_cw_backend.model.DeliveryServiceConstructionCrewEntity;
import com.example.db_cw_backend.model.MaterialBuildingEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MaterialBuildingRepository extends CrudRepository<MaterialBuildingEntity, Integer> {
    @Override
    List<MaterialBuildingEntity> findAll();
}
