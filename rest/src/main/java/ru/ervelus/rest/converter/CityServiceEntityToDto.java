package ru.ervelus.rest.converter;

import ru.ervelus.rest.model.BuildingEntity;
import ru.ervelus.rest.model.CityServiceEntity;
import ru.ervelus.rest.transfer.BuildingDto;
import ru.ervelus.rest.transfer.CityServiceDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class CityServiceEntityToDto implements Converter<CityServiceEntity, CityServiceDto> {
    @Override
    public CityServiceDto convert(CityServiceEntity source) {
        CityServiceDto dto = new CityServiceDto();
        dto.setId(source.getId());
        dto.setType(source.getType());
        dto.setPrice(source.getPrice());
        dto.setModelId(source.getModel().getId());
        dto.setBuildingIds(source.getBuildings().stream().map(BuildingEntity::getId).collect(Collectors.toList()));
        return dto;
    }
}
