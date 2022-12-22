package com.example.db_cw_backend.converter;

import com.example.db_cw_backend.model.ConstructionCrewEntity;
import com.example.db_cw_backend.model.DeliveryServiceEntity;
import com.example.db_cw_backend.transfer.ConstructionCrewDto;
import com.example.db_cw_backend.transfer.DeliveryServiceDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class DeliveryEntityToDto implements Converter<DeliveryServiceEntity, DeliveryServiceDto> {
    @Override
    public DeliveryServiceDto convert(DeliveryServiceEntity source) {
        DeliveryServiceDto dto = new DeliveryServiceDto();
        dto.setId(source.getId());
        dto.setName(source.getName());
        dto.setRate(source.getRate());
        dto.setMaterialId(source.getMaterial().getId());
        dto.setCrewIds(source.getCrews().stream().map(ConstructionCrewEntity::getId).collect(Collectors.toList()));
        return dto;
    }
}
