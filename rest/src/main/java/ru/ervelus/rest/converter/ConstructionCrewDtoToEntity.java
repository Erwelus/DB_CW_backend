package ru.ervelus.rest.converter;

import ru.ervelus.rest.model.BuildingEntity;
import ru.ervelus.rest.model.CityServiceEntity;
import ru.ervelus.rest.model.ConstructionCrewEntity;
import ru.ervelus.rest.model.DeliveryServiceEntity;
import ru.ervelus.rest.repository.DeliveryServiceRepository;
import ru.ervelus.rest.repository.ModelRepository;
import ru.ervelus.rest.transfer.ConstructionCrewDto;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class ConstructionCrewDtoToEntity implements Converter<ConstructionCrewDto, ConstructionCrewEntity> {
    private final ModelRepository modelRepository;
    private final DeliveryServiceRepository deliveryServiceRepository;

    @Override
    public ConstructionCrewEntity convert(ConstructionCrewDto source) {
        ConstructionCrewEntity entity = new ConstructionCrewEntity();
        entity.setId(source.getId());
        entity.setSize(source.getSize());
        modelRepository.findById(source.getModelId()).ifPresent(entity::setModel);
        List<DeliveryServiceEntity> deliveries = new ArrayList<>();
        source.getDeliveryServiceIds().forEach(id -> {
            deliveryServiceRepository.findById(id).ifPresent(deliveries::add);
        });
        entity.setDeliveryServices(deliveries);
        return entity;
    }
}
