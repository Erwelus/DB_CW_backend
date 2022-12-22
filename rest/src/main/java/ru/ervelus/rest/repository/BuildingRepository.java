package ru.ervelus.rest.repository;

import ru.ervelus.rest.model.BuildingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface BuildingRepository extends JpaRepository<BuildingEntity, Long> {
    @Query("select building from BuildingEntity building where building.street.id=:streetId")
    List<BuildingEntity> findAllByStreetId(@Param("streetId") Long streetId);
}
