package com.example.db_cw_backend.repository;

import com.example.db_cw_backend.model.StreetEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StreetRepository extends JpaRepository<StreetEntity, Long> {
    @Query("select street from StreetEntity street where street.quarter.id=:quarterId")
    List<StreetEntity> findAllByQuarterId(@Param("quarterId") Long quarterId);
}
