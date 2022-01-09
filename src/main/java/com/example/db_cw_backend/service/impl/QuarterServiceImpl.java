package com.example.db_cw_backend.service.impl;

import com.example.db_cw_backend.model.QuarterEntity;
import com.example.db_cw_backend.service.QuarterService;
import com.example.db_cw_backend.transfer.QuarterDto;
import org.springframework.stereotype.Service;

@Service
public class QuarterServiceImpl implements QuarterService {

    @Override
    public QuarterEntity prepareEntity(QuarterDto data) {
        QuarterEntity entity = new QuarterEntity();
        entity.setId(data.getId());
        entity.setName(data.getName());
        entity.setX(data.getX());
        entity.setY(data.getY());
        return entity;
    }

    @Override
    public QuarterDto prepareDto(QuarterEntity entity) {
        QuarterDto response = new QuarterDto();
        response.setId(entity.getId());
        response.setName(entity.getName());
        response.setX(entity.getX());
        response.setY(entity.getY());
        return response;
    }
}
