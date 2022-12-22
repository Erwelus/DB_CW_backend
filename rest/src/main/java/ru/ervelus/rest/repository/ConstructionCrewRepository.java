package ru.ervelus.rest.repository;

import ru.ervelus.rest.model.CityServiceEntity;
import ru.ervelus.rest.model.ConstructionCrewEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ConstructionCrewRepository extends JpaRepository<ConstructionCrewEntity, Long> {
    @Query("select crew from ConstructionCrewEntity crew where crew.model.id=:modelId")
    List<ConstructionCrewEntity> findAllByModelId(@Param("modelId") Long modelId);
}
