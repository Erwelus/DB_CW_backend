package com.example.db_cw_backend.service;

import com.example.db_cw_backend.model.RouteStreetEntity;
import com.example.db_cw_backend.transfer.RouteStreetDto;

public interface RouteStreetService {
    RouteStreetEntity prepareEntity(RouteStreetDto data);
    RouteStreetDto prepareDto(RouteStreetEntity entity);
}
