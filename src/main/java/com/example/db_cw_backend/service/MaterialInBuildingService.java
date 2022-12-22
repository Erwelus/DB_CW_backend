package com.example.db_cw_backend.service;

import com.example.db_cw_backend.model.MaterialInBuilding;
import com.example.db_cw_backend.repository.MaterialInBuildingRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class MaterialInBuildingService {
    private final MaterialInBuildingRepository repository;

    public MaterialInBuildingService(MaterialInBuildingRepository repository) {
        this.repository = repository;
    }

    public List<MaterialInBuilding> findAll() {
        return repository.findAll();
    }

    public MaterialInBuilding findById(Long id) {
        return repository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public void save(MaterialInBuilding entity) {
        repository.save(entity);
    }
}
