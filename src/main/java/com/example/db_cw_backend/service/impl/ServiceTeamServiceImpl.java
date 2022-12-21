package com.example.db_cw_backend.service.impl;

import com.example.db_cw_backend.model.ServiceTeamEntity;
import com.example.db_cw_backend.service.ServiceTeamService;
import com.example.db_cw_backend.transfer.ServiceTeamDto;
import org.springframework.stereotype.Service;

@Service
public class ServiceTeamServiceImpl implements ServiceTeamService {

    @Override
    public ServiceTeamEntity prepareEntity(ServiceTeamDto data) {
        ServiceTeamEntity entity = new ServiceTeamEntity();
        entity.setId(data.getId());
        entity.setRate(data.getRate());
        entity.setQuarterId(data.getQuarterId());
        entity.setCityServiceId(data.getCityServiceId());
        entity.setCityServiceByServiceId(data.getCityServiceByServiceId());
        entity.setQuarterByQuarterId(data.getQuarterByQuarterId());
        return entity;
    }

    @Override
    public ServiceTeamDto prepareDto(ServiceTeamEntity entity) {
        ServiceTeamDto response = new ServiceTeamDto();
        response.setId(entity.getId());
        response.setRate(entity.getRate());
        response.setQuarterId(entity.getQuarterId());
        response.setCityServiceId(entity.getCityServiceId());
        response.setCityServiceByServiceId(entity.getCityServiceByServiceId());
        response.setQuarterByQuarterId(entity.getQuarterByQuarterId());
        return response;
    }
}
