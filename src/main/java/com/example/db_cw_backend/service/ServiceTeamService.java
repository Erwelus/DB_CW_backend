package com.example.db_cw_backend.service;

import com.example.db_cw_backend.model.ServiceTeamEntity;
import com.example.db_cw_backend.transfer.ServiceTeamDto;

public interface ServiceTeamService {
    ServiceTeamEntity prepareEntity(ServiceTeamDto data);
    ServiceTeamDto prepareDto(ServiceTeamEntity entity);
}
