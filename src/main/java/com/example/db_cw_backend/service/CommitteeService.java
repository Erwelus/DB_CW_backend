package com.example.db_cw_backend.service;


import com.example.db_cw_backend.model.CommitteeEntity;
import com.example.db_cw_backend.transfer.CommitteeDto;

public interface CommitteeService {
    CommitteeEntity prepareEntity(CommitteeDto data);
    CommitteeDto prepareDto(CommitteeEntity entity);
}
