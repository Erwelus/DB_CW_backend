package ru.ervelus.rest.converter;

import ru.ervelus.rest.model.QuarterEntity;
import ru.ervelus.rest.model.RouteEntity;
import ru.ervelus.rest.model.StreetEntity;
import ru.ervelus.rest.transfer.QuarterDto;
import ru.ervelus.rest.transfer.RouteDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class RouteEntityToDto implements Converter<RouteEntity, RouteDto> {
    @Override
    public RouteDto convert(RouteEntity source) {
        RouteDto dto = new RouteDto();
        dto.setId(source.getId());
        dto.setType(source.getType());
        dto.setModelId(source.getModel().getId());
        dto.setQuarterIds(source.getQuarters().stream().map(QuarterEntity::getId).collect(Collectors.toList()));
        dto.setStreetIds(source.getStreets().stream().map(StreetEntity::getId).collect(Collectors.toList()));
        return dto;
    }
}
