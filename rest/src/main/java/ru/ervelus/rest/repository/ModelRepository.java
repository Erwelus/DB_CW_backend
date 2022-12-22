package ru.ervelus.rest.repository;

import ru.ervelus.rest.model.ModelEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepository extends JpaRepository<ModelEntity, Long> {
}
