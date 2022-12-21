package com.example.db_cw_backend.service.impl;

import com.example.db_cw_backend.model.RouteQuartersEntity;
import com.example.db_cw_backend.service.RouteQuartersService;
import com.example.db_cw_backend.transfer.RouteQuartersDto;
import org.springframework.stereotype.Service;

@Service
public class RouteQuartersServiceImpl implements RouteQuartersService {

    @Override
    public RouteQuartersEntity prepareEntity(RouteQuartersDto data) {
        RouteQuartersEntity entity = new RouteQuartersEntity();
        entity.setRouteId(data.getRouteId());
        entity.setQuarterFrom(data.getQuarterFrom());
        entity.setQuarterTo(data.getQuarterTo());
        entity.setRouteByRouteId(data.getRouteByRouteId());
        entity.setQuarterByQuarterTo(data.getQuarterByQuarterTo());
        entity.setQuarterByQuarterFrom(data.getQuarterByQuarterFrom());
        return entity;
    }

    @Override
    public RouteQuartersDto prepareDto(RouteQuartersEntity entity) {
        RouteQuartersDto response = new RouteQuartersDto();
        response.setRouteId(entity.getRouteId());
        response.setQuarterFrom(entity.getQuarterFrom());
        response.setQuarterTo(entity.getQuarterTo());
        response.setRouteByRouteId(entity.getRouteByRouteId());
        response.setQuarterByQuarterTo(entity.getQuarterByQuarterTo());
        response.setQuarterByQuarterFrom(entity.getQuarterByQuarterFrom());
        return response;
    }
}
