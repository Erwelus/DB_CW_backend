package com.example.db_cw_backend.service;

import com.example.db_cw_backend.model.CityServiceEntity;
import com.example.db_cw_backend.repository.CityServiceRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Objects;

@Service
public class CityServiceService {
    private final CityServiceRepository repository;

    public CityServiceService(CityServiceRepository repository) {
        this.repository = repository;
    }

    public List<CityServiceEntity> findAll(Long modelId) {
        return repository.findAllByModelId(modelId);
    }

    public CityServiceEntity findById(Long id, Long streetId) {
        CityServiceEntity entity = repository.findById(id).orElseThrow(EntityNotFoundException::new);
        if (!Objects.equals(entity.getModel().getId(), streetId)) throw new IllegalArgumentException();
        return entity;
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public void save(CityServiceEntity cityService) {
        repository.save(cityService);
    }
}
