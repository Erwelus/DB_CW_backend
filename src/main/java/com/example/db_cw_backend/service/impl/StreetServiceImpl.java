package com.example.db_cw_backend.service.impl;

import com.example.db_cw_backend.model.StreetEntity;
import com.example.db_cw_backend.service.StreetService;
import com.example.db_cw_backend.transfer.StreetDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StreetServiceImpl implements StreetService {

    @Override
    public StreetEntity prepareEntity(StreetDto data) {
        StreetEntity entity = new StreetEntity();
        entity.setId(data.getId());
        entity.setName(data.getName());
        entity.setQuarterId(data.getQuarterId());
        entity.setQuarter(data.getQuarterByQuarterId());
        return entity;
    }

    @Override
    public StreetDto prepareDto(StreetEntity entity, List<String> streetList) {
        StreetDto response = new StreetDto();
        response.setId(entity.getId());
        response.setName(entity.getName());
        response.setQuarterId(entity.getQuarterId());
        response.setQuarterByQuarterId(entity.getQuarter());
        response.setStreetList(streetList);
        return response;
    }
}
