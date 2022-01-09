package com.example.db_cw_backend.repository;

import com.example.db_cw_backend.model.DeliveryServiceConstructionCrewEntity;
import com.example.db_cw_backend.model.RouteQuartersEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RouteQuartersRepository extends CrudRepository<RouteQuartersEntity, Integer> {
    @Override
    List<RouteQuartersEntity> findAll();
}
