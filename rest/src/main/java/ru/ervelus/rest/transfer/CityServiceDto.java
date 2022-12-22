package ru.ervelus.rest.transfer;

import ru.ervelus.rest.model.BuildingEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
public class CityServiceDto implements Serializable {
    private Long id;
    private String type;
    private Float price;
    private List<Long> buildingIds;
    private Long modelId;
}
