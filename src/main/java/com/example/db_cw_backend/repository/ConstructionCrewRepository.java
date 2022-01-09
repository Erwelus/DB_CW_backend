package com.example.db_cw_backend.repository;

import com.example.db_cw_backend.model.CityServiceBuildingEntity;
import com.example.db_cw_backend.model.ConstructionCrewEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ConstructionCrewRepository extends CrudRepository<ConstructionCrewEntity, Integer> {
    @Override
    List<ConstructionCrewEntity> findAll();
}
