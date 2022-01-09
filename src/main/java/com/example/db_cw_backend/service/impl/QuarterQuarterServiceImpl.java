package com.example.db_cw_backend.service.impl;

import com.example.db_cw_backend.model.QuarterQuarterEntity;
import com.example.db_cw_backend.service.QuarterQuarterService;
import com.example.db_cw_backend.transfer.QuarterQuarterDto;
import org.springframework.stereotype.Service;

@Service
public class QuarterQuarterServiceImpl implements QuarterQuarterService {

    @Override
    public QuarterQuarterEntity prepareEntity(QuarterQuarterDto data) {
        QuarterQuarterEntity entity = new QuarterQuarterEntity();
        entity.setId(data.getId());
        entity.setQuarter1Id(data.getQuarter1Id());
        entity.setQuarter2Id(data.getQuarter2Id());
        return entity;
    }

    @Override
    public QuarterQuarterDto prepareDto(QuarterQuarterEntity entity) {
        QuarterQuarterDto response = new QuarterQuarterDto();
        response.setId(entity.getId());
        response.setQuarter1Id(entity.getQuarter1Id());
        response.setQuarter2Id(entity.getQuarter2Id());
        return response;
    }
}
