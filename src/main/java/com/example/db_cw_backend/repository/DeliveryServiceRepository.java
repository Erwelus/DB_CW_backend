package com.example.db_cw_backend.repository;

import com.example.db_cw_backend.model.DeliveryServiceConstructionCrewEntity;
import com.example.db_cw_backend.model.DeliveryServiceEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface DeliveryServiceRepository extends CrudRepository<DeliveryServiceEntity, Integer> {
    @Override
    List<DeliveryServiceEntity> findAll();
    DeliveryServiceEntity findByName(String name);
    @Transactional
    void deleteByName(String name);
}
