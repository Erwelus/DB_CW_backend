package com.example.db_cw_backend.converter;

import com.example.db_cw_backend.model.BuildingEntity;
import com.example.db_cw_backend.model.ConstructionCrewEntity;
import com.example.db_cw_backend.model.DeliveryServiceEntity;
import com.example.db_cw_backend.transfer.CityServiceDto;
import com.example.db_cw_backend.transfer.ConstructionCrewDto;
import org.springframework.core.convert.converter.Converter;

import java.util.stream.Collectors;

public class ConstructionCrewEntityToDto implements Converter<ConstructionCrewEntity, ConstructionCrewDto> {
    @Override
    public ConstructionCrewDto convert(ConstructionCrewEntity source) {
        ConstructionCrewDto dto = new ConstructionCrewDto();
        dto.setId(source.getId());
        dto.setSize(source.getSize());
        dto.setModelId(source.getModel().getId());
        dto.setDeliveryServiceIds(source.getDeliveryServices().stream().map(DeliveryServiceEntity::getId).collect(Collectors.toList()));
        return dto;
    }
}
