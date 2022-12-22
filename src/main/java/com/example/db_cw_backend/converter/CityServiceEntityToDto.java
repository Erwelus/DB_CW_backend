package com.example.db_cw_backend.converter;

import com.example.db_cw_backend.model.BuildingEntity;
import com.example.db_cw_backend.model.CityServiceEntity;
import com.example.db_cw_backend.transfer.BuildingDto;
import com.example.db_cw_backend.transfer.CityServiceDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class CityServiceEntityToDto implements Converter<CityServiceEntity, CityServiceDto> {
    @Override
    public CityServiceDto convert(CityServiceEntity source) {
        CityServiceDto dto = new CityServiceDto();
        dto.setId(source.getId());
        dto.setType(source.getType());
        dto.setPrice(source.getPrice());
        dto.setModelId(source.getModel().getId());
        dto.setBuildingIds(source.getBuildings().stream().map(BuildingEntity::getId).collect(Collectors.toList()));
        return dto;
    }
}
