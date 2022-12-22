package com.example.db_cw_backend.converter;

import com.example.db_cw_backend.model.ConstructionCrewEntity;
import com.example.db_cw_backend.model.QuarterEntity;
import com.example.db_cw_backend.model.RouteEntity;
import com.example.db_cw_backend.transfer.DeliveryServiceDto;
import com.example.db_cw_backend.transfer.QuarterDto;
import org.springframework.core.convert.converter.Converter;

import java.util.stream.Collectors;

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
