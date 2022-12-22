package ru.ervelus.rest.converter;

import ru.ervelus.rest.model.RouteEntity;
import ru.ervelus.rest.model.StreetEntity;
import ru.ervelus.rest.transfer.StreetDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class StreetEntityToDto implements Converter<StreetEntity, StreetDto> {
    @Override
    public StreetDto convert(StreetEntity source) {
        StreetDto dto = new StreetDto();
        dto.setId(source.getId());
        dto.setName(source.getName());
        dto.setQuarterId(source.getQuarter().getId());
        dto.setRouteIds(source.getRoutes().stream().map(RouteEntity::getId).collect(Collectors.toList()));
        return dto;
    }
}
