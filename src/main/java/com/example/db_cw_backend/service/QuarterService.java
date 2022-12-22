package com.example.db_cw_backend.service;

import com.example.db_cw_backend.model.QuarterEntity;
import com.example.db_cw_backend.model.StreetEntity;
import com.example.db_cw_backend.repository.QuarterRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class QuarterService {
    private final QuarterRepository repository;
    private final StreetService streetService;

    public QuarterService(QuarterRepository repository, StreetService streetService) {
        this.repository = repository;
        this.streetService = streetService;
    }

    public QuarterEntity findById(Long id, Long modelId) {
        QuarterEntity entity = repository.findById(id).orElseThrow(EntityNotFoundException::new);
        if (!Objects.equals(entity.getModel().getId(), modelId)) throw new IllegalArgumentException();
        return entity;
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public void save(QuarterEntity entity) {
        repository.save(entity);
    }

    public List<QuarterEntity> findAll(Long modelId) {
        return repository.findAllByModelId(modelId);
    }

    public Double calculateCost(Long id) {
        List<Long> streets = streetService.findAll(id).stream().map(StreetEntity::getId).collect(Collectors.toList());
        return streets.stream().mapToDouble(streetService::calculateCost).sum();
    }

    public Double getPercentage(Long id) {
        List<Long> streets = streetService.findAll(id).stream().map(StreetEntity::getId).collect(Collectors.toList());
        return streets.stream().mapToDouble(streetService::getPercentage).average().orElse(0);
    }
}
