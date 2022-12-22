package ru.ervelus.rest.service;

import ru.ervelus.rest.model.ConstructionCrewEntity;
import ru.ervelus.rest.repository.ConstructionCrewRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Objects;

@Service
public class ConstructionCrewService {
    private final ConstructionCrewRepository repository;

    public ConstructionCrewService(ConstructionCrewRepository repository) {
        this.repository = repository;
    }

    public List<ConstructionCrewEntity> findAll(Long modelId) {
        return repository.findAllByModelId(modelId);
    }

    public ConstructionCrewEntity findById(Long id, Long modelId) {
        ConstructionCrewEntity entity = repository.findById(id).orElseThrow(EntityNotFoundException::new);
        if (!Objects.equals(entity.getModel().getId(), modelId)) throw new IllegalArgumentException();
        return entity;
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public void save(ConstructionCrewEntity entity) {
        repository.save(entity);
    }
}
