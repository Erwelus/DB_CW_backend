package com.example.db_cw_backend.repository;

import com.example.db_cw_backend.model.DeliveryServiceConstructionCrewEntity;
import com.example.db_cw_backend.model.RouteStreetEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RouteStreetRepository extends CrudRepository<RouteStreetEntity, Integer> {
    @Override
    List<RouteStreetEntity> findAll();
}
