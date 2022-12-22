package com.example.db_cw_backend.service;

import com.example.db_cw_backend.model.DeliveryServiceEntity;
import com.example.db_cw_backend.model.MaterialEntity;
import com.example.db_cw_backend.model.MaterialInBuilding;
import com.example.db_cw_backend.repository.MaterialInBuildingRepository;
import com.example.db_cw_backend.repository.MaterialRepository;
import com.example.db_cw_backend.service.MaterialService;
import com.example.db_cw_backend.transfer.MaterialDto;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Objects;

@Service
public class MaterialService {
    private final MaterialRepository repository;

    public MaterialService(MaterialRepository repository) {
        this.repository = repository;
    }

    public List<MaterialEntity> findAll(Long modelId) {
        return repository.findAllByModelId(modelId);
    }

    public MaterialEntity findById(Long id, Long modelId) {
        MaterialEntity entity = repository.findById(id).orElseThrow(EntityNotFoundException::new);
        if (!Objects.equals(entity.getModel().getId(), modelId)) throw new IllegalArgumentException();
        return entity;
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public void save(MaterialEntity entity) {
        repository.save(entity);
    }
}
