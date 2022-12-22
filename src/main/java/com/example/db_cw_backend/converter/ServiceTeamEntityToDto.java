package com.example.db_cw_backend.converter;

import com.example.db_cw_backend.model.QuarterEntity;
import com.example.db_cw_backend.model.ServiceTeamEntity;
import com.example.db_cw_backend.model.StreetEntity;
import com.example.db_cw_backend.transfer.RouteDto;
import com.example.db_cw_backend.transfer.ServiceTeamDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class ServiceTeamEntityToDto implements Converter<ServiceTeamEntity, ServiceTeamDto> {
    @Override
    public ServiceTeamDto convert(ServiceTeamEntity source) {
        ServiceTeamDto dto = new ServiceTeamDto();
        dto.setId(source.getId());
        dto.setRate(source.getRate());
        dto.setQuarterId(source.getQuarter().getId());
        dto.setCityServiceId(source.getCityService().getId());
        return dto;
    }
}
