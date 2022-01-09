package com.example.db_cw_backend.repository;

import com.example.db_cw_backend.model.CityServiceBuildingEntity;
import com.example.db_cw_backend.model.CityServiceEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CityServiceRepository extends CrudRepository<CityServiceEntity, Integer> {
    @Override
    List<CityServiceEntity> findAll();
}
