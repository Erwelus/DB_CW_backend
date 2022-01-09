package com.example.db_cw_backend.service;

import com.example.db_cw_backend.model.MaterialEntity;
import com.example.db_cw_backend.transfer.MaterialDto;

public interface MaterialService {
    MaterialEntity prepareEntity(MaterialDto data);
    MaterialDto prepareDto(MaterialEntity entity);
}
