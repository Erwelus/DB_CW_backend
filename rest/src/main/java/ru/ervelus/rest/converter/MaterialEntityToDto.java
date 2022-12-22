package ru.ervelus.rest.converter;

import ru.ervelus.rest.model.BuildingEntity;
import ru.ervelus.rest.model.ConstructionCrewEntity;
import ru.ervelus.rest.model.MaterialEntity;
import ru.ervelus.rest.transfer.DeliveryServiceDto;
import ru.ervelus.rest.transfer.MaterialDto;
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
