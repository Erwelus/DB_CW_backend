package ru.ervelus.rest.converter;

import ru.ervelus.rest.model.BuildingEntity;
import ru.ervelus.rest.model.CityServiceEntity;
import ru.ervelus.rest.model.MaterialInBuilding;
import ru.ervelus.rest.repository.BuildingRepository;
import ru.ervelus.rest.repository.ModelRepository;
import ru.ervelus.rest.transfer.CityServiceDto;
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
