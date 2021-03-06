package com.example.db_cw_backend.repository;

import com.example.db_cw_backend.model.BuildingEntity;
import com.example.db_cw_backend.model.CityServiceBuildingEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BuildingRepository extends CrudRepository<BuildingEntity, Integer> {
    @Query(value = "select (count_building_cost(?1)) ", nativeQuery = true)
    Double countBuildingCost(Integer buildingId);
    List<BuildingEntity> findAllByStreetId(Integer streetId);
    @Override
    List<BuildingEntity> findAll();
}
