package com.example.db_cw_backend.converter;

import com.example.db_cw_backend.model.MaterialEntity;
import com.example.db_cw_backend.model.MaterialInBuilding;
import com.example.db_cw_backend.model.QuarterEntity;
import com.example.db_cw_backend.model.RouteEntity;
import com.example.db_cw_backend.repository.ModelRepository;
import com.example.db_cw_backend.repository.RouteRepository;
import com.example.db_cw_backend.transfer.QuarterDto;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class QuarterDtoToEntity implements Converter<QuarterDto, QuarterEntity> {
    private final ModelRepository modelRepository;
    private final RouteRepository routeRepository;

    @Override
    public QuarterEntity convert(QuarterDto source) {
        QuarterEntity entity = new QuarterEntity();
        entity.setId(source.getId());
        entity.setX(source.getX());
        entity.setY(source.getY());
        entity.setName(source.getName());
        modelRepository.findById(source.getModelId()).ifPresent(entity::setModel);
        List<RouteEntity> routes = new ArrayList<>();
        source.getRouteIds().forEach(id -> {
            routeRepository.findById(id).ifPresent(routes::add);
        });
        entity.setRoutes(routes);
        return entity;
    }
}
