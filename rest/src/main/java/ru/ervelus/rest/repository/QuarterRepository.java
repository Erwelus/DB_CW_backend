package ru.ervelus.rest.repository;

import ru.ervelus.rest.model.QuarterEntity;
import ru.ervelus.rest.model.StreetEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface QuarterRepository extends JpaRepository<QuarterEntity, Long> {
    @Query("select quarter from QuarterEntity quarter where quarter.model.id=:modelId")
    List<QuarterEntity> findAllByModelId(@Param("modelId") Long modelId);
}
