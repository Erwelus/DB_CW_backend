package com.example.db_cw_backend.service.impl;

import com.example.db_cw_backend.model.MaterialEntity;
import com.example.db_cw_backend.service.MaterialService;
import com.example.db_cw_backend.transfer.MaterialDto;
import org.springframework.stereotype.Service;

@Service
public class MaterialServiceImpl implements MaterialService {

    @Override
    public MaterialEntity prepareEntity(MaterialDto data) {
        MaterialEntity entity = new MaterialEntity();
        entity.setId(data.getId());
        entity.setType(data.getType());
        entity.setQuantity(data.getQuantity());
        entity.setPrice(data.getPrice());
        return entity;
    }

    @Override
    public MaterialDto prepareDto(MaterialEntity entity) {
        MaterialDto response = new MaterialDto();
        response.setId(entity.getId());
        response.setType(entity.getType());
        response.setQuantity(entity.getQuantity());
        response.setPrice(entity.getPrice());
        return response;
    }
}
