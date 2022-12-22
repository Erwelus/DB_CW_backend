package com.example.db_cw_backend.converter;

import com.example.db_cw_backend.model.*;
import com.example.db_cw_backend.repository.BuildingRepository;
import com.example.db_cw_backend.repository.MaterialInBuildingRepository;
import com.example.db_cw_backend.repository.ModelRepository;
import com.example.db_cw_backend.transfer.MaterialDto;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class MaterialDtoToEntity implements Converter<MaterialDto, MaterialEntity> {
    private final ModelRepository modelRepository;
    private final MaterialInBuildingRepository materialRepository;

    @Override
    public MaterialEntity convert(MaterialDto source) {
        MaterialEntity entity = new MaterialEntity();
        entity.setId(source.getId());
        entity.setPrice(source.getPrice());
        entity.setType(source.getType());
        entity.setQuantity(source.getQuantity());
        modelRepository.findById(source.getModelId()).ifPresent(entity::setModel);
        List<MaterialInBuilding> buildings = new ArrayList<>();
        source.getBuildingIds().forEach(id -> {
            materialRepository.findById(id).ifPresent(buildings::add);
        });
        entity.setBuildings(buildings);
        return entity;
    }
}
