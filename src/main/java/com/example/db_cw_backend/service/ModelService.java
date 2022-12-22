package com.example.db_cw_backend.service;

import com.example.db_cw_backend.model.ModelEntity;
import com.example.db_cw_backend.model.QuarterEntity;
import com.example.db_cw_backend.repository.ModelRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ModelService {
    private final ModelRepository repository;
    private final QuarterService quarterService;

    public ModelService(ModelRepository repository, QuarterService quarterService) {
        this.repository = repository;
        this.quarterService = quarterService;
    }

    public List<ModelEntity> findAll() {
        return repository.findAll();
    }

    public ModelEntity findById(Long id) {
        return repository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public void save(ModelEntity entity) {
        repository.save(entity);
    }

    public Double calculateCost(Long id) {
        List<Long> quarters = quarterService.findAll(id).stream().map(QuarterEntity::getId).collect(Collectors.toList());
        return quarters.stream().mapToDouble(quarterService::calculateCost).sum();
    }

    public Double getPercentage(Long id) {
        List<Long> quarters = quarterService.findAll(id).stream().map(QuarterEntity::getId).collect(Collectors.toList());
        return quarters.stream().mapToDouble(quarterService::getPercentage).average().orElse(0);
    }

}
