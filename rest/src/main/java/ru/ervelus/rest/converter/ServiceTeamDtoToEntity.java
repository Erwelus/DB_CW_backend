package ru.ervelus.rest.converter;

import ru.ervelus.rest.model.QuarterEntity;
import ru.ervelus.rest.model.RouteEntity;
import ru.ervelus.rest.model.ServiceTeamEntity;
import ru.ervelus.rest.model.StreetEntity;
import ru.ervelus.rest.repository.CityServiceRepository;
import ru.ervelus.rest.repository.QuarterRepository;
import ru.ervelus.rest.transfer.ServiceTeamDto;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class ServiceTeamDtoToEntity implements Converter<ServiceTeamDto, ServiceTeamEntity> {
    private final QuarterRepository quarterRepository;
    private final CityServiceRepository serviceRepository;

    @Override
    public ServiceTeamEntity convert(ServiceTeamDto source) {
        ServiceTeamEntity entity = new ServiceTeamEntity();
        entity.setId(source.getId());
        entity.setRate(source.getRate());
        quarterRepository.findById(source.getQuarterId()).ifPresent(entity::setQuarter);
        serviceRepository.findById(source.getCityServiceId()).ifPresent(entity::setCityService);
        return entity;
    }
}
