package ru.ervelus.rest.repository;

import ru.ervelus.rest.model.DeliveryServiceEntity;
import ru.ervelus.rest.model.MaterialEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface MaterialRepository extends JpaRepository<MaterialEntity, Long> {
    @Query("select material from MaterialEntity material where material.model.id=:modelId")
    List<MaterialEntity> findAllByModelId(@Param("modelId") Long modelId);
}
