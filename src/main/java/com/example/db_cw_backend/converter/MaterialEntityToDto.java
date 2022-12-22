package com.example.db_cw_backend.converter;

import com.example.db_cw_backend.model.BuildingEntity;
import com.example.db_cw_backend.model.ConstructionCrewEntity;
import com.example.db_cw_backend.model.MaterialEntity;
import com.example.db_cw_backend.transfer.DeliveryServiceDto;
import com.example.db_cw_backend.transfer.MaterialDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class MaterialEntityToDto implements Converter<MaterialEntity, MaterialDto> {
    @Override
    public MaterialDto convert(MaterialEntity source) {
        MaterialDto dto = new MaterialDto();
        dto.setId(source.getId());
        dto.setType(source.getType());
        dto.setPrice(source.getPrice());
        dto.setQuantity(source.getQuantity());
        dto.setModelId(source.getModel().getId());
        dto.setBuildingIds(source.getBuildings().stream().map(e -> e.getBuilding().getId()).collect(Collectors.toList()));
        return dto;
    }
}
