package ru.ervelus.rest.converter;

import ru.ervelus.rest.model.MaterialEntity;
import ru.ervelus.rest.model.MaterialInBuilding;
import ru.ervelus.rest.model.QuarterEntity;
import ru.ervelus.rest.model.RouteEntity;
import ru.ervelus.rest.repository.ModelRepository;
import ru.ervelus.rest.repository.RouteRepository;
import ru.ervelus.rest.transfer.QuarterDto;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
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
