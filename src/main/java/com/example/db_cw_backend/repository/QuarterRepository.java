package com.example.db_cw_backend.repository;

import com.example.db_cw_backend.model.QuarterEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface QuarterRepository extends CrudRepository<QuarterEntity, Integer> {
    @Query(value = "select (count_readiness_percentage_of_quarter(?1)) ", nativeQuery = true)
    Double calculateReadinessPercentage(Integer quarterId);

    @Override
    List<QuarterEntity> findAll();
}
