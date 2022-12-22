package ru.ervelus.rest.service;

import ru.ervelus.rest.model.DeliveryServiceEntity;
import ru.ervelus.rest.model.MaterialEntity;
import ru.ervelus.rest.model.MaterialInBuilding;
import ru.ervelus.rest.repository.MaterialInBuildingRepository;
import ru.ervelus.rest.repository.MaterialRepository;
import ru.ervelus.rest.service.MaterialService;
import ru.ervelus.rest.transfer.MaterialDto;
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
