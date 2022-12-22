package ru.ervelus.rest.service;

import ru.ervelus.rest.model.BuildingEntity;
import ru.ervelus.rest.model.ServiceTeamEntity;
import ru.ervelus.rest.model.StreetEntity;
import ru.ervelus.rest.repository.StreetRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Objects;

@Service
public class StreetService {
    private final StreetRepository repository;
    private final BuildingService buildingService;

    public StreetService(StreetRepository repository, BuildingService buildingService) {
        this.repository = repository;
        this.buildingService = buildingService;
    }

    public List<StreetEntity> findAll(Long quarterId) {
        return repository.findAllByQuarterId(quarterId);
    }

    public StreetEntity findById(Long id, Long quarterId) {
        StreetEntity entity = repository.findById(id).orElseThrow(EntityNotFoundException::new);
        if (!Objects.equals(entity.getQuarter().getId(), quarterId)) throw new IllegalArgumentException();
        return entity;
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public void save(StreetEntity entity) {
        repository.save(entity);
    }

    public Double calculateCost(Long id) {
        List<BuildingEntity> buildings = buildingService.findAll(id);
        return buildings.stream().mapToDouble(buildingService::calculateCost).sum();
    }

    public Double getPercentage(Long id) {
        List<BuildingEntity> buildings = buildingService.findAll(id);
        return buildings.stream().mapToInt(BuildingEntity::getReadinessCoefficient).average().orElse(0);
    }
}
