package com.example.db_cw_backend.transfer;

import com.example.db_cw_backend.model.DeliveryServiceEntity;
import com.example.db_cw_backend.model.ModelEntity;
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
