package ru.ervelus.rest.converter;

import ru.ervelus.rest.model.RouteEntity;
import ru.ervelus.rest.model.StreetEntity;
import ru.ervelus.rest.repository.QuarterRepository;
import ru.ervelus.rest.repository.RouteRepository;
import ru.ervelus.rest.transfer.StreetDto;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
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
