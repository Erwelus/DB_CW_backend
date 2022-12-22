package ru.ervelus.rest.converter;

import ru.ervelus.rest.model.ConstructionCrewEntity;
import ru.ervelus.rest.model.DeliveryServiceEntity;
import ru.ervelus.rest.repository.ConstructionCrewRepository;
import ru.ervelus.rest.repository.MaterialRepository;
import ru.ervelus.rest.transfer.DeliveryServiceDto;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DeliveryDtoToEntity implements Converter<DeliveryServiceDto, DeliveryServiceEntity> {
    private final MaterialRepository materialRepository;
    private final ConstructionCrewRepository crewRepository;

    @Override
    public DeliveryServiceEntity convert(DeliveryServiceDto source) {
        DeliveryServiceEntity entity = new DeliveryServiceEntity();
        entity.setId(source.getId());
        entity.setName(source.getName());
        entity.setRate(source.getRate());
        materialRepository.findById(source.getMaterialId()).ifPresent(entity::setMaterial);
        List<ConstructionCrewEntity> crews = new ArrayList<>();
        source.getCrewIds().forEach(id -> {
            crewRepository.findById(id).ifPresent(crews::add);
        });
        entity.setCrews(crews);
        return entity;
    }
}
