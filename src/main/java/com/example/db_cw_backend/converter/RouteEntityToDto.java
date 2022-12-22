package com.example.db_cw_backend.converter;

import com.example.db_cw_backend.model.QuarterEntity;
import com.example.db_cw_backend.model.RouteEntity;
import com.example.db_cw_backend.model.StreetEntity;
import com.example.db_cw_backend.transfer.QuarterDto;
import com.example.db_cw_backend.transfer.RouteDto;
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
