package com.example.db_cw_backend.service.impl;

import com.example.db_cw_backend.model.RouteEntity;
import com.example.db_cw_backend.service.RouteService;
import com.example.db_cw_backend.transfer.RouteDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouteServiceImpl implements RouteService {

    @Override
    public RouteEntity prepareEntity(RouteDto data) {
        RouteEntity entity = new RouteEntity();
        entity.setId(data.getId());
        entity.setType(data.getType());
        return entity;
    }

    @Override
    public RouteDto prepareDto(RouteEntity entity, String quarterTo, String quarterFrom, List<String> streets) {
        RouteDto response = new RouteDto();
        response.setId(entity.getId());
        response.setType(entity.getType());
        response.setQuarterFrom(quarterFrom);
        response.setQuarterTo(quarterTo);
        response.setStreets(streets);
        return response;
    }
}
