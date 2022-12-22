package com.example.db_cw_backend.repository;

import com.example.db_cw_backend.model.RouteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RouteRepository extends JpaRepository<RouteEntity, Long> {
    @Query("select route from RouteEntity route where route.model.id=:modelId")
    List<RouteEntity> findAllByModelId(@Param("modelId") Long modelId);
}
