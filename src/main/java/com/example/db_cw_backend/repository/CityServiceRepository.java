package com.example.db_cw_backend.repository;

import com.example.db_cw_backend.model.BuildingEntity;
import com.example.db_cw_backend.model.CityServiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CityServiceRepository extends JpaRepository<CityServiceEntity, Long> {
    @Query("select service from CityServiceEntity service where service.model.id=:modelId")
    List<CityServiceEntity> findAllByModelId(@Param("modelId") Long modelId);
}
