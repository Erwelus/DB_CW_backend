package com.example.db_cw_backend.service.impl;

import com.example.db_cw_backend.model.MaterialBuildingEntity;
import com.example.db_cw_backend.service.MaterialBuildingService;
import com.example.db_cw_backend.transfer.MaterialBuildingDto;
import org.springframework.stereotype.Service;

@Service
public class MaterialBuildingServiceImpl implements MaterialBuildingService {

    @Override
    public MaterialBuildingEntity prepareEntity(MaterialBuildingDto data) {
        MaterialBuildingEntity entity = new MaterialBuildingEntity();
        entity.setBuildingId(data.getBuildingId());
        entity.setMaterialId(data.getMaterialId());
        entity.setQuantity(data.getQuantity());
        entity.setBuildingByBuildingId(data.getBuildingByBuildingId());
        entity.setMaterialByMaterialId(data.getMaterialByMaterialId());
        return entity;
    }

    @Override
    public MaterialBuildingDto prepareDto(MaterialBuildingEntity entity) {
        MaterialBuildingDto response = new MaterialBuildingDto();
        response.setBuildingId(entity.getBuildingId());
        response.setMaterialId(entity.getMaterialId());
        response.setQuantity(entity.getQuantity());
        response.setBuildingByBuildingId(entity.getBuildingByBuildingId());
        response.setMaterialByMaterialId(entity.getMaterialByMaterialId());
        return response;
    }
}
