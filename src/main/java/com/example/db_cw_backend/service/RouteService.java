package com.example.db_cw_backend.service;

import com.example.db_cw_backend.model.RouteEntity;
import com.example.db_cw_backend.transfer.RouteDto;

import java.util.List;

public interface RouteService {
    RouteEntity prepareEntity(RouteDto data);
    RouteDto prepareDto(RouteEntity entity, String quarterTo, String quarterFrom, List<String> streets);
}
