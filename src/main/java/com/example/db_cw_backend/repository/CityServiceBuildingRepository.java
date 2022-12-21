package com.example.db_cw_backend.repository;

import com.example.db_cw_backend.model.CityServiceBuildingEntity;
import com.example.db_cw_backend.model.QuarterEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CityServiceBuildingRepository extends CrudRepository<CityServiceBuildingEntity, Integer> {
    @Override
    List<CityServiceBuildingEntity> findAll();
    List<CityServiceBuildingEntity> findAllByBuildingId(Integer id);
}
