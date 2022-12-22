package com.example.db_cw_backend.converter;

import com.example.db_cw_backend.model.RouteEntity;
import com.example.db_cw_backend.model.StreetEntity;
import com.example.db_cw_backend.transfer.StreetDto;
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
