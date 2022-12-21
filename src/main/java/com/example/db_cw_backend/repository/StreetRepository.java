package com.example.db_cw_backend.repository;

import com.example.db_cw_backend.model.DeliveryServiceConstructionCrewEntity;
import com.example.db_cw_backend.model.StreetEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface StreetRepository extends CrudRepository<StreetEntity, Integer> {
    @Query(value = "select (count_readiness_percentage_of_street(?1)) ", nativeQuery = true)
    Double calculateReadinessPercentage(Integer streetId);
    List<StreetEntity> findAllByQuarterId(Integer quarterId);
    StreetEntity findByName(String name);
    @Transactional
    void deleteByName(String name);
    @Override
    List<StreetEntity> findAll();
}
