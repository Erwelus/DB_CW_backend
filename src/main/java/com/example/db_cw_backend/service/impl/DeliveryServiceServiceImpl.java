package com.example.db_cw_backend.service.impl;

import com.example.db_cw_backend.model.DeliveryServiceEntity;
import com.example.db_cw_backend.service.DeliveryServiceService;
import com.example.db_cw_backend.transfer.DeliveryServiceDto;
import org.springframework.stereotype.Service;

@Service
public class DeliveryServiceServiceImpl implements DeliveryServiceService {

    @Override
    public DeliveryServiceEntity prepareEntity(DeliveryServiceDto data) {
        DeliveryServiceEntity entity = new DeliveryServiceEntity();
        entity.setId(data.getId());
        entity.setName(data.getName());
        entity.setRate(data.getRate());
        entity.setMaterialId(data.getMaterialId());
        entity.setMaterialByMaterialId(data.getMaterialByMaterialId());
        return entity;
    }

    @Override
    public DeliveryServiceDto prepareDto(DeliveryServiceEntity entity) {
        DeliveryServiceDto response = new DeliveryServiceDto();
        response.setId(entity.getId());
        response.setName(entity.getName());
        response.setRate(entity.getRate());
        response.setMaterialId(entity.getMaterialId());
        response.setMaterialByMaterialId(entity.getMaterialByMaterialId());
        return response;
    }
}
