package ru.ervelus.rest.converter;

import ru.ervelus.rest.model.ConstructionCrewEntity;
import ru.ervelus.rest.model.QuarterEntity;
import ru.ervelus.rest.model.RouteEntity;
import ru.ervelus.rest.transfer.DeliveryServiceDto;
import ru.ervelus.rest.transfer.QuarterDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class QuarterEntityToDto implements Converter<QuarterEntity, QuarterDto> {
    @Override
    public QuarterDto convert(QuarterEntity source) {
        QuarterDto dto = new QuarterDto();
        dto.setId(source.getId());
        dto.setName(source.getName());
        dto.setX(source.getX());
        dto.setY(source.getY());
        dto.setModelId(source.getModel().getId());
        dto.setRouteIds(source.getRoutes().stream().map(RouteEntity::getId).collect(Collectors.toList()));
        return dto;
    }
}
