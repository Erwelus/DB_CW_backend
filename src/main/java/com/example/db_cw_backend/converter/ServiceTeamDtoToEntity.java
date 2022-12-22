package com.example.db_cw_backend.converter;

import com.example.db_cw_backend.model.QuarterEntity;
import com.example.db_cw_backend.model.RouteEntity;
import com.example.db_cw_backend.model.ServiceTeamEntity;
import com.example.db_cw_backend.model.StreetEntity;
import com.example.db_cw_backend.repository.CityServiceRepository;
import com.example.db_cw_backend.repository.QuarterRepository;
import com.example.db_cw_backend.transfer.ServiceTeamDto;
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
