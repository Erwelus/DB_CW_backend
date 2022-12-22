package ru.ervelus.rest.converter;

import ru.ervelus.rest.model.ConstructionCrewEntity;
import ru.ervelus.rest.model.DeliveryServiceEntity;
import ru.ervelus.rest.transfer.ConstructionCrewDto;
import ru.ervelus.rest.transfer.DeliveryServiceDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class DeliveryEntityToDto implements Converter<DeliveryServiceEntity, DeliveryServiceDto> {
    @Override
    public DeliveryServiceDto convert(DeliveryServiceEntity source) {
        DeliveryServiceDto dto = new DeliveryServiceDto();
        dto.setId(source.getId());
        dto.setName(source.getName());
        dto.setRate(source.getRate());
        dto.setMaterialId(source.getMaterial().getId());
        dto.setCrewIds(source.getCrews().stream().map(ConstructionCrewEntity::getId).collect(Collectors.toList()));
        return dto;
    }
}
