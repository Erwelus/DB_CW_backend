package com.example.db_cw_backend.repository;

import com.example.db_cw_backend.model.DeliveryServiceConstructionCrewEntity;
import com.example.db_cw_backend.model.ServiceTeamEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ServiceTeamRepository extends CrudRepository<ServiceTeamEntity, Integer> {
    @Override
    List<ServiceTeamEntity> findAll();
}
