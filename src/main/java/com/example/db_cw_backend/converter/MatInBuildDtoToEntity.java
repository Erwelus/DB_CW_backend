package com.example.db_cw_backend.converter;

import com.example.db_cw_backend.model.MaterialInBuilding;
import com.example.db_cw_backend.repository.BuildingRepository;
import com.example.db_cw_backend.repository.MaterialRepository;
import com.example.db_cw_backend.transfer.MaterialInBuildingDto;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MatInBuildDtoToEntity implements Converter<MaterialInBuildingDto, MaterialInBuilding> {
    private final BuildingRepository buildingRepository;
    private final MaterialRepository materialRepository;

    @Override
    public MaterialInBuilding convert(MaterialInBuildingDto source) {
        MaterialInBuilding entity = new MaterialInBuilding();
        entity.setId(source.getId());
        entity.setQuantity(source.getQuantity());
        buildingRepository.findById(source.getBuildingId()).ifPresent(entity::setBuilding);
        materialRepository.findById(source.getMaterialId()).ifPresent(entity::setMaterial);
        return entity;
    }
}
