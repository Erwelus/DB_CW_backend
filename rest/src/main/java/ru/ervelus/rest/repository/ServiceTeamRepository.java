package ru.ervelus.rest.repository;

import ru.ervelus.rest.model.ServiceTeamEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ServiceTeamRepository extends JpaRepository<ServiceTeamEntity, Long> {
    @Query("select team from ServiceTeamEntity team where team.cityService.id=:serviceId")
    List<ServiceTeamEntity> findAllByCityServiceId(@Param("serviceId") Long serviceId);
}
