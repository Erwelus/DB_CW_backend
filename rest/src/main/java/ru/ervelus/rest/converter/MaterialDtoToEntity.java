package ru.ervelus.rest.converter;

import ru.ervelus.rest.model.*;
import ru.ervelus.rest.repository.BuildingRepository;
import ru.ervelus.rest.repository.MaterialInBuildingRepository;
import ru.ervelus.rest.repository.ModelRepository;
import ru.ervelus.rest.transfer.MaterialDto;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
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
