package com.example.db_cw_backend.repository;

import com.example.db_cw_backend.model.CityServiceBuildingEntity;
import com.example.db_cw_backend.model.CommitteeEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CommitteeRepository extends CrudRepository<CommitteeEntity, Integer> {
    @Query(value = "select (accept_ready_buildings_for_committee(?1)) ", nativeQuery = true)
    Double acceptReadyBuildingsForCommittee(Integer committeeId);
    @Override
    List<CommitteeEntity> findAll();
}
