package com.example.db_cw_backend.service.impl;

import com.example.db_cw_backend.model.CommitteeEntity;
import com.example.db_cw_backend.service.CommitteeService;
import com.example.db_cw_backend.transfer.CommitteeDto;
import org.springframework.stereotype.Service;

@Service
public class CommitteeServiceImpl implements CommitteeService {

    @Override
    public CommitteeEntity prepareEntity(CommitteeDto data) {
        CommitteeEntity entity = new CommitteeEntity();
        entity.setId(data.getId());
        entity.setStrictness(data.getStrictness());
        return entity;
    }

    @Override
    public CommitteeDto prepareDto(CommitteeEntity entity) {
        CommitteeDto response = new CommitteeDto();
        response.setId(entity.getId());
        response.setStrictness(entity.getStrictness());
        return response;
    }
}
