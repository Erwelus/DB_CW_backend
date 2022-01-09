package com.example.db_cw_backend.service.impl;

import com.example.db_cw_backend.model.CityServiceEntity;
import com.example.db_cw_backend.service.CityServiceService;
import com.example.db_cw_backend.transfer.CityServiceDto;
import org.springframework.stereotype.Service;

@Service
public class CityServiceServiceImpl implements CityServiceService {

    @Override
    public CityServiceEntity prepareEntity(CityServiceDto data) {
        CityServiceEntity entity = new CityServiceEntity();
        entity.setId(data.getId());
        entity.setPrice(data.getPrice());
        entity.setType(data.getType());
        return entity;
    }

    @Override
    public CityServiceDto prepareDto(CityServiceEntity entity) {
        CityServiceDto response = new CityServiceDto();
        response.setId(entity.getId());
        response.setPrice(entity.getPrice());
        response.setType(entity.getType());
        return response;
    }
}
