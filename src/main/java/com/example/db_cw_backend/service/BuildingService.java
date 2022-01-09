package com.example.db_cw_backend.service;

import com.example.db_cw_backend.model.BuildingEntity;
import com.example.db_cw_backend.transfer.BuildingDto;


public interface BuildingService {
    BuildingEntity prepareEntity(BuildingDto data);
    BuildingDto prepareDto(BuildingEntity entity);
}
