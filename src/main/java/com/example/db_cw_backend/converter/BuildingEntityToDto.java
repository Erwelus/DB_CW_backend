package com.example.db_cw_backend.converter;

import com.example.db_cw_backend.model.BuildingEntity;
import com.example.db_cw_backend.model.CityServiceEntity;
import com.example.db_cw_backend.model.MaterialEntity;
import com.example.db_cw_backend.model.MaterialInBuilding;
import com.example.db_cw_backend.transfer.BuildingDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class BuildingEntityToDto implements Converter<BuildingEntity, BuildingDto> {
    @Override
    public BuildingDto convert(BuildingEntity source) {
        BuildingDto dto = new BuildingDto();
        dto.setId(source.getId());
        dto.setType(source.getType());
        dto.setReadinessCoefficient(source.getReadinessCoefficient());
        dto.setName(source.getName());
        dto.setFloorNumber(source.getFloorNumber());
        dto.setStreetId(source.getStreet().getId());
        dto.setConstructionCrewId(source.getConstructionCrew().getId());
        dto.setServiceIds(source.getServices().stream().map(CityServiceEntity::getId).collect(Collectors.toList()));
        dto.setMaterialIds(source.getMaterials().stream().map(e -> e.getMaterial().getId()).collect(Collectors.toList()));
        return dto;
    }
}
