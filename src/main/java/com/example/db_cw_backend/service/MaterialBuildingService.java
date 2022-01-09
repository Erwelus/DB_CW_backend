package com.example.db_cw_backend.service;

import com.example.db_cw_backend.model.MaterialBuildingEntity;
import com.example.db_cw_backend.transfer.MaterialBuildingDto;

public interface MaterialBuildingService {
    MaterialBuildingEntity prepareEntity(MaterialBuildingDto data);
    MaterialBuildingDto prepareDto(MaterialBuildingEntity entity);
}
