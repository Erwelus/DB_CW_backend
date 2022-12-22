package com.example.db_cw_backend.converter;

import com.example.db_cw_backend.model.QuarterEntity;
import com.example.db_cw_backend.model.RouteEntity;
import com.example.db_cw_backend.model.StreetEntity;
import com.example.db_cw_backend.repository.ModelRepository;
import com.example.db_cw_backend.repository.QuarterRepository;
import com.example.db_cw_backend.repository.StreetRepository;
import com.example.db_cw_backend.transfer.RouteDto;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class RouteDtoToEntity implements Converter<RouteDto, RouteEntity> {
    private final ModelRepository modelRepository;
    private final QuarterRepository quarterRepository;
    private final StreetRepository streetRepository;

    @Override
    public RouteEntity convert(RouteDto source) {
        RouteEntity entity = new RouteEntity();
        entity.setId(source.getId());
        entity.setType(source.getType());
        modelRepository.findById(source.getModelId()).ifPresent(entity::setModel);
        List<QuarterEntity> quarters = new ArrayList<>();
        source.getQuarterIds().forEach(id -> {
            quarterRepository.findById(id).ifPresent(quarters::add);
        });
        entity.setQuarters(quarters);
        List<StreetEntity> streets = new ArrayList<>();
        source.getStreetIds().forEach(id -> {
            streetRepository.findById(id).ifPresent(streets::add);
        });
        entity.setStreets(streets);
        return entity;
    }
}
