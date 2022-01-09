package com.example.db_cw_backend.repository;

import com.example.db_cw_backend.model.DeliveryServiceConstructionCrewEntity;
import com.example.db_cw_backend.model.QuarterQuarterEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface QuarterQuarterRepository extends CrudRepository<QuarterQuarterEntity, Integer> {
    @Override
    List<QuarterQuarterEntity> findAll();
}
