package com.example.db_cw_backend.converter;

import com.example.db_cw_backend.model.BuildingEntity;
import com.example.db_cw_backend.model.CityServiceEntity;
import com.example.db_cw_backend.model.MaterialInBuilding;
import com.example.db_cw_backend.repository.BuildingRepository;
import com.example.db_cw_backend.repository.ModelRepository;
import com.example.db_cw_backend.transfer.CityServiceDto;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class CityServiceDtoToEntity implements Converter<CityServiceDto, CityServiceEntity> {
    private final ModelRepository modelRepository;
    private final BuildingRepository buildingRepository;

    @Override
    public CityServiceEntity convert(CityServiceDto source) {
        CityServiceEntity entity = new CityServiceEntity();
        entity.setId(source.getId());
        entity.setType(source.getType());
        entity.setPrice(source.getPrice());
        modelRepository.findById(source.getModelId()).ifPresent(entity::setModel);
        List<BuildingEntity> buildings = new ArrayList<>();
        source.getBuildingIds().forEach(id -> {
            buildingRepository.findById(id).ifPresent(buildings::add);
        });
        entity.setBuildings(buildings);
        return entity;
    }
}
