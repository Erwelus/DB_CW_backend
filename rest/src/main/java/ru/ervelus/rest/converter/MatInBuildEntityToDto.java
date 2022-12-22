package ru.ervelus.rest.converter;

import ru.ervelus.rest.model.ConstructionCrewEntity;
import ru.ervelus.rest.model.MaterialInBuilding;
import ru.ervelus.rest.transfer.DeliveryServiceDto;
import ru.ervelus.rest.transfer.MaterialInBuildingDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class MatInBuildEntityToDto implements Converter<MaterialInBuilding, MaterialInBuildingDto> {
    @Override
    public MaterialInBuildingDto convert(MaterialInBuilding source) {
        MaterialInBuildingDto dto = new MaterialInBuildingDto();
        dto.setId(source.getId());
        dto.setMaterialId(source.getMaterial().getId());
        dto.setBuildingId(source.getBuilding().getId());
        dto.setQuantity(source.getQuantity());
        return dto;
    }
}
