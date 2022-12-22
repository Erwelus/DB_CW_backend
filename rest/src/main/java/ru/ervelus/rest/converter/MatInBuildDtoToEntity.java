package ru.ervelus.rest.converter;

import ru.ervelus.rest.model.MaterialInBuilding;
import ru.ervelus.rest.repository.BuildingRepository;
import ru.ervelus.rest.repository.MaterialRepository;
import ru.ervelus.rest.transfer.MaterialInBuildingDto;
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
