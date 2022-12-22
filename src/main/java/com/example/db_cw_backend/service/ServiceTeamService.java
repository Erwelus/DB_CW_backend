package com.example.db_cw_backend.service;

import com.example.db_cw_backend.model.ServiceTeamEntity;
import com.example.db_cw_backend.repository.ServiceTeamRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Objects;

@Service
public class ServiceTeamService {
    private final ServiceTeamRepository repository;

    public ServiceTeamService(ServiceTeamRepository repository) {
        this.repository = repository;
    }

    public List<ServiceTeamEntity> findAll(Long serviceId) {
        return repository.findAllByCityServiceId(serviceId);
    }

    public ServiceTeamEntity findById(Long id, Long serviceId) {
        ServiceTeamEntity entity = repository.findById(id).orElseThrow(EntityNotFoundException::new);
        if (!Objects.equals(entity.getCityService().getId(), serviceId)) throw new IllegalArgumentException();
        return entity;
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public void save(ServiceTeamEntity entity) {
        repository.save(entity);
    }
}
