package com.example.db_cw_backend.service;

import com.example.db_cw_backend.model.MaterialEntity;
import com.example.db_cw_backend.model.QuarterEntity;
import com.example.db_cw_backend.model.RouteEntity;
import com.example.db_cw_backend.repository.QuarterRepository;
import com.example.db_cw_backend.repository.RouteRepository;
import com.example.db_cw_backend.service.RouteService;
import com.example.db_cw_backend.transfer.RouteDto;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Objects;

@Service
public class RouteService {
    private final RouteRepository repository;

    public RouteService(RouteRepository repository) {
        this.repository = repository;
    }

    public List<RouteEntity> findAll(Long modelId) {
        return repository.findAllByModelId(modelId);
    }

    public RouteEntity findById(Long id, Long modelId) {
        RouteEntity entity = repository.findById(id).orElseThrow(EntityNotFoundException::new);
        if (!Objects.equals(entity.getModel().getId(), modelId)) throw new IllegalArgumentException();
        return entity;
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public void save(RouteEntity entity) {
        repository.save(entity);
    }
}
