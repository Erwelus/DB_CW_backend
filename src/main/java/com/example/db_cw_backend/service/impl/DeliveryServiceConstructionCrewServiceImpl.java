package com.example.db_cw_backend.service.impl;

import com.example.db_cw_backend.model.CityServiceEntity;
import com.example.db_cw_backend.model.DeliveryServiceConstructionCrewEntity;
import com.example.db_cw_backend.service.DeliveryServiceConstructionCrewService;
import com.example.db_cw_backend.transfer.DeliveryServiceConstructionCrewDto;
import org.springframework.stereotype.Service;

@Service
public class DeliveryServiceConstructionCrewServiceImpl implements DeliveryServiceConstructionCrewService {

    @Override
    public DeliveryServiceConstructionCrewEntity prepareEntity(DeliveryServiceConstructionCrewDto data) {
        DeliveryServiceConstructionCrewEntity entity = new DeliveryServiceConstructionCrewEntity();
        entity.setConstructionCrewId(data.getConstructionCrewId());
        entity.setDeliveryServiceId(data.getDeliveryServiceId());
        return entity;
    }

    @Override
    public DeliveryServiceConstructionCrewDto prepareDto(DeliveryServiceConstructionCrewEntity entity) {
        DeliveryServiceConstructionCrewDto response = new DeliveryServiceConstructionCrewDto();
        response.setConstructionCrewId(entity.getConstructionCrewId());
        response.setDeliveryServiceId(entity.getDeliveryServiceId());
        return response;
    }
}
