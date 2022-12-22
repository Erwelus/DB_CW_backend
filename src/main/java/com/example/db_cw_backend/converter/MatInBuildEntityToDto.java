package com.example.db_cw_backend.converter;

import com.example.db_cw_backend.model.ConstructionCrewEntity;
import com.example.db_cw_backend.model.MaterialInBuilding;
import com.example.db_cw_backend.transfer.DeliveryServiceDto;
import com.example.db_cw_backend.transfer.MaterialInBuildingDto;
import org.springframework.core.convert.converter.Converter;

import java.util.stream.Collectors;

public class MatInBuildEntityToDto implements Converter<MaterialInBuilding, MaterialInBuildingDto> {
    @Override
    public MaterialInBuildingDto convert(MaterialInBuilding source) {
        MaterialInBuildingDto dto = new MaterialInBuildingDto();
        dto.setMaterialId(source.getMaterial().getId());
        dto.setBuildingId(source.getBuilding().getId());
        dto.setQuantity(source.getQuantity());
        return dto;
    }
}