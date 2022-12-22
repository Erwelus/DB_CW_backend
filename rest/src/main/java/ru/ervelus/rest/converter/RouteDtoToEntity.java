package ru.ervelus.rest.converter;

import ru.ervelus.rest.model.QuarterEntity;
import ru.ervelus.rest.model.RouteEntity;
import ru.ervelus.rest.model.StreetEntity;
import ru.ervelus.rest.repository.ModelRepository;
import ru.ervelus.rest.repository.QuarterRepository;
import ru.ervelus.rest.repository.StreetRepository;
import ru.ervelus.rest.transfer.RouteDto;
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
