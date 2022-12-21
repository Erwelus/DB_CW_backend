package com.example.db_cw_backend.service.impl;

import com.example.db_cw_backend.model.StreetStreetEntity;
import com.example.db_cw_backend.service.StreetStreetService;
import com.example.db_cw_backend.transfer.StreetStreetDto;
import org.springframework.stereotype.Service;

@Service
public class StreetStreetServiceImpl implements StreetStreetService {

    @Override
    public StreetStreetEntity prepareEntity(StreetStreetDto data) {
        StreetStreetEntity entity = new StreetStreetEntity();
        entity.setId(data.getId());
        entity.setStreet1Id(data.getStreet1Id());
        entity.setStreet2Id(data.getStreet2Id());
        entity.setStreet1ByStreet1Id(data.getStreet1ByStreet1Id());
        entity.setStreet2ByStreet2Id(data.getStreet2ByStreet2Id());
        return entity;
    }

    @Override
    public StreetStreetDto prepareDto(StreetStreetEntity entity) {
        StreetStreetDto response = new StreetStreetDto();
        response.setId(entity.getId());
        response.setStreet1Id(entity.getStreet1Id());
        response.setStreet2Id(entity.getStreet2Id());
        response.setStreet1ByStreet1Id(entity.getStreet1ByStreet1Id());
        response.setStreet2ByStreet2Id(entity.getStreet2ByStreet2Id());
        return response;
    }
}
