package ru.ervelus.rest.converter;

import ru.ervelus.rest.model.BuildingEntity;
import ru.ervelus.rest.model.ConstructionCrewEntity;
import ru.ervelus.rest.model.DeliveryServiceEntity;
import ru.ervelus.rest.transfer.CityServiceDto;
import ru.ervelus.rest.transfer.ConstructionCrewDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class ConstructionCrewEntityToDto implements Converter<ConstructionCrewEntity, ConstructionCrewDto> {
    @Override
    public ConstructionCrewDto convert(ConstructionCrewEntity source) {
        ConstructionCrewDto dto = new ConstructionCrewDto();
        dto.setId(source.getId());
        dto.setSize(source.getSize());
        dto.setModelId(source.getModel().getId());
        dto.setDeliveryServiceIds(source.getDeliveryServices().stream().map(DeliveryServiceEntity::getId).collect(Collectors.toList()));
        return dto;
    }
}
