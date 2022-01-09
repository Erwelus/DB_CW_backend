package com.example.db_cw_backend.service.impl;

import com.example.db_cw_backend.model.RouteStreetEntity;
import com.example.db_cw_backend.service.RouteStreetService;
import com.example.db_cw_backend.transfer.RouteStreetDto;
import org.springframework.stereotype.Service;

@Service
public class RouteStreetServiceImpl implements RouteStreetService {

    @Override
    public RouteStreetEntity prepareEntity(RouteStreetDto data) {
        RouteStreetEntity entity = new RouteStreetEntity();
        entity.setRouteId(data.getRouteId());
        entity.setStreetId(data.getStreetId());
        return entity;
    }

    @Override
    public RouteStreetDto prepareDto(RouteStreetEntity entity) {
        RouteStreetDto response = new RouteStreetDto();
        response.setRouteId(entity.getRouteId());
        response.setStreetId(entity.getStreetId());
        return response;
    }
}
