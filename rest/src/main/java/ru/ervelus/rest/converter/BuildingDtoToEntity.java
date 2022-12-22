package ru.ervelus.rest.converter;

import ru.ervelus.rest.model.BuildingEntity;
import ru.ervelus.rest.model.CityServiceEntity;
import ru.ervelus.rest.model.MaterialEntity;
import ru.ervelus.rest.model.MaterialInBuilding;
import ru.ervelus.rest.repository.*;
import ru.ervelus.rest.transfer.BuildingDto;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class BuildingDtoToEntity implements Converter<BuildingDto, BuildingEntity> {
    private final StreetRepository streetRepository;
    private final ConstructionCrewRepository constructionCrewRepository;
    private final CityServiceRepository cityServiceRepository;
    private final MaterialInBuildingRepository materialRepository;

    @Override
    public BuildingEntity convert(BuildingDto source) {
        BuildingEntity entity = new BuildingEntity();
        entity.setId(source.getId());
        entity.setType(source.getType());
        entity.setReadinessCoefficient(source.getReadinessCoefficient());
        entity.setName(source.getName());
        entity.setFloorNumber(source.getFloorNumber());
        streetRepository.findById(source.getStreetId()).ifPresent(entity::setStreet);
        constructionCrewRepository.findById(source.getConstructionCrewId()).ifPresent(entity::setConstructionCrew);
        List<CityServiceEntity> services = new ArrayList<>();
        source.getServiceIds().forEach(id -> {
            cityServiceRepository.findById(id).ifPresent(services::add);
        });
        entity.setServices(services);
        List<MaterialInBuilding> materials = new ArrayList<>();
        source.getMaterialIds().forEach(id -> {
            materialRepository.findById(id).ifPresent(materials::add);
        });
        entity.setMaterials(materials);
        return entity;
    }
}
