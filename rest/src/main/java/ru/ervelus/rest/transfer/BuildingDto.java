package ru.ervelus.rest.transfer;

import ru.ervelus.rest.model.CityServiceEntity;
import ru.ervelus.rest.model.ConstructionCrewEntity;
import ru.ervelus.rest.model.MaterialEntity;
import ru.ervelus.rest.model.StreetEntity;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class BuildingDto implements Serializable {
    private Long id;
    private String type;
    private String name;
    private Integer floorNumber;
    private Integer readinessCoefficient;
    private Long streetId;
    private Long constructionCrewId;
    private List<Long> serviceIds;
    private List<Long> materialIds;
}
