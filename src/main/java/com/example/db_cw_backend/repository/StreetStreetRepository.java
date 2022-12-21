package com.example.db_cw_backend.repository;

import com.example.db_cw_backend.model.DeliveryServiceConstructionCrewEntity;
import com.example.db_cw_backend.model.StreetStreetEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface StreetStreetRepository extends CrudRepository<StreetStreetEntity, Integer> {
    @Override
    List<StreetStreetEntity> findAll();
    List<StreetStreetEntity> findAllByStreet1Id(Integer id);
    @Transactional
    void deleteAllByStreet1Id(Integer id);
    @Transactional
    void deleteAllByStreet2Id(Integer id);
}
