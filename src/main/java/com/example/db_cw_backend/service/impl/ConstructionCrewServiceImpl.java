package com.example.db_cw_backend.service.impl;

import com.example.db_cw_backend.model.ConstructionCrewEntity;
import com.example.db_cw_backend.service.ConstructionCrewService;
import com.example.db_cw_backend.transfer.ConstructionCrewDto;
import org.springframework.stereotype.Service;

@Service
public class ConstructionCrewServiceImpl implements ConstructionCrewService {

    @Override
    public ConstructionCrewEntity prepareEntity(ConstructionCrewDto data) {
        ConstructionCrewEntity entity = new ConstructionCrewEntity();
        entity.setId(data.getId());
        entity.setSize(data.getSize());
        return entity;
    }

    @Override
    public ConstructionCrewDto prepareDto(ConstructionCrewEntity entity) {
        ConstructionCrewDto response = new ConstructionCrewDto();
        response.setId(entity.getId());
        response.setSize(entity.getSize());
        return response;
    }
}
