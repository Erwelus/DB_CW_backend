package com.example.db_cw_backend.service;

import com.example.db_cw_backend.model.RouteQuartersEntity;
import com.example.db_cw_backend.transfer.RouteQuartersDto;

public interface RouteQuartersService {
    RouteQuartersEntity prepareEntity(RouteQuartersDto data);
    RouteQuartersDto prepareDto(RouteQuartersEntity entity);
}
