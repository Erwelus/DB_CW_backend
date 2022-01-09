package com.example.db_cw_backend.repository;

import com.example.db_cw_backend.model.CityServiceBuildingEntity;
import com.example.db_cw_backend.model.DeliveryServiceConstructionCrewEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DeliveryServiceConstructionCrewRepository extends CrudRepository<DeliveryServiceConstructionCrewEntity, Integer> {
    @Override
    List<DeliveryServiceConstructionCrewEntity> findAll();
}
