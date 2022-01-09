package com.example.db_cw_backend.service.impl;

import com.example.db_cw_backend.model.CityServiceBuildingEntity;
import com.example.db_cw_backend.service.CityServiceBuildingService;
import com.example.db_cw_backend.transfer.CityServiceBuildingDto;
import org.springframework.stereotype.Service;

@Service
public class CityServiceBuildingServiceImpl implements CityServiceBuildingService {

    @Override
    public CityServiceBuildingEntity prepareEntity(CityServiceBuildingDto data) {
        CityServiceBuildingEntity entity = new CityServiceBuildingEntity();
        entity.setServiceId(data.getServiceId());
        entity.setBuildingId(data.getBuildingId());
        return entity;
    }

    @Override
    public CityServiceBuildingDto prepareDto(CityServiceBuildingEntity entity) {
        CityServiceBuildingDto response = new CityServiceBuildingDto();
        response.setServiceId(entity.getServiceId());
        response.setBuildingId(entity.getBuildingId());
        return response;
    }
}
