package ru.ervelus.rest.transfer;

import ru.ervelus.rest.model.CityServiceEntity;
import ru.ervelus.rest.model.QuarterEntity;
import lombok.Data;

import java.io.Serializable;

@Data
public class ServiceTeamDto implements Serializable {
    private Long id;
    private Float rate;
    private Long quarterId;
    private Long cityServiceId;
}
