package ru.ervelus.rest.transfer;

import ru.ervelus.rest.model.DeliveryServiceEntity;
import ru.ervelus.rest.model.ModelEntity;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class ConstructionCrewDto implements Serializable {
    private Long id;
    private Integer size;
    private Long modelId;
    private List<Long> deliveryServiceIds;
}
