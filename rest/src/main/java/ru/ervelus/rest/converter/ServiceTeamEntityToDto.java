package ru.ervelus.rest.converter;

import ru.ervelus.rest.model.QuarterEntity;
import ru.ervelus.rest.model.ServiceTeamEntity;
import ru.ervelus.rest.model.StreetEntity;
import ru.ervelus.rest.transfer.RouteDto;
import ru.ervelus.rest.transfer.ServiceTeamDto;
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
