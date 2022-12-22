package com.example.db_cw_backend.repository;

import com.example.db_cw_backend.model.ModelEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepository extends JpaRepository<ModelEntity, Long> {
}
