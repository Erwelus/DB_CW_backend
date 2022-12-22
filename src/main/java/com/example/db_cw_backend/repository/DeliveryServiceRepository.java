package com.example.db_cw_backend.repository;

import com.example.db_cw_backend.model.ConstructionCrewEntity;
import com.example.db_cw_backend.model.DeliveryServiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface DeliveryServiceRepository extends JpaRepository<DeliveryServiceEntity, Long> {
    @Query("select delivery from DeliveryServiceEntity delivery where delivery.material.id=:materialId")
    List<DeliveryServiceEntity> findAllByMaterialId(@Param("materialId") Long materialId);
}
