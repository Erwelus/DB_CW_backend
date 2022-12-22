package com.example.db_cw_backend.service;

import com.example.db_cw_backend.model.ConstructionCrewEntity;
import com.example.db_cw_backend.model.DeliveryServiceEntity;
import com.example.db_cw_backend.repository.DeliveryServiceRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Objects;

@Service
public class DeliveryServiceService {
    private final DeliveryServiceRepository repository;

    public DeliveryServiceService(DeliveryServiceRepository repository) {
        this.repository = repository;
    }

    public List<DeliveryServiceEntity> findAll(Long materialId) {
        return repository.findAllByMaterialId(materialId);
    }

    public DeliveryServiceEntity findById(Long id, Long materialId) {
        DeliveryServiceEntity entity = repository.findById(id).orElseThrow(EntityNotFoundException::new);
        if (!Objects.equals(entity.getMaterial().getId(), materialId)) throw new IllegalArgumentException();
        return entity;
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public void save(DeliveryServiceEntity entity) {
        repository.save(entity);
    }
}
