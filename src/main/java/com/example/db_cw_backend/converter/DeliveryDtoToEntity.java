package com.example.db_cw_backend.converter;

import com.example.db_cw_backend.model.ConstructionCrewEntity;
import com.example.db_cw_backend.model.DeliveryServiceEntity;
import com.example.db_cw_backend.repository.ConstructionCrewRepository;
import com.example.db_cw_backend.repository.MaterialRepository;
import com.example.db_cw_backend.transfer.DeliveryServiceDto;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;

import java.util.ArrayList;
import java.util.List;

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
