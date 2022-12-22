package com.example.db_cw_backend.converter;

import com.example.db_cw_backend.model.RouteEntity;
import com.example.db_cw_backend.model.StreetEntity;
import com.example.db_cw_backend.repository.QuarterRepository;
import com.example.db_cw_backend.repository.RouteRepository;
import com.example.db_cw_backend.transfer.StreetDto;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class StreetDtoToEntity implements Converter<StreetDto, StreetEntity> {
    private final QuarterRepository quarterRepository;
    private final RouteRepository routeRepository;

    @Override
    public StreetEntity convert(StreetDto source) {
        StreetEntity entity = new StreetEntity();
        entity.setId(source.getId());
        entity.setName(source.getName());
        quarterRepository.findById(source.getQuarterId()).ifPresent(entity::setQuarter);
        List<RouteEntity> routes = new ArrayList<>();
        source.getRouteIds().forEach(id -> {
            routeRepository.findById(id).ifPresent(routes::add);
        });
        entity.setRoutes(routes);
        return entity;
    }
}
