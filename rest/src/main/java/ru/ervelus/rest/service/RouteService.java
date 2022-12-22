package ru.ervelus.rest.service;

import ru.ervelus.rest.model.MaterialEntity;
import ru.ervelus.rest.model.QuarterEntity;
import ru.ervelus.rest.model.RouteEntity;
import ru.ervelus.rest.repository.QuarterRepository;
import ru.ervelus.rest.repository.RouteRepository;
import ru.ervelus.rest.service.RouteService;
import ru.ervelus.rest.transfer.RouteDto;
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
