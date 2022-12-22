package com.example.db_cw_backend.converter;

import com.example.db_cw_backend.model.BuildingEntity;
import com.example.db_cw_backend.model.CityServiceEntity;
import com.example.db_cw_backend.model.ConstructionCrewEntity;
import com.example.db_cw_backend.model.DeliveryServiceEntity;
import com.example.db_cw_backend.repository.DeliveryServiceRepository;
import com.example.db_cw_backend.repository.ModelRepository;
import com.example.db_cw_backend.transfer.ConstructionCrewDto;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;

import java.util.ArrayList;
import java.util.List;

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
