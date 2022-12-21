package com.example.db_cw_backend.transfer;

import com.example.db_cw_backend.model.ConstructionCrewEntity;
import com.example.db_cw_backend.model.DeliveryServiceEntity;
import lombok.Data;

import java.io.Serializable;

@Data
public class DeliveryServiceConstructionCrewDto implements Serializable {
    private Integer deliveryServiceId;
    private Integer constructionCrewId;
    private DeliveryServiceEntity deliveryServiceByDeliveryServiceId;
    private ConstructionCrewEntity constructionCrewByConstructionCrewId;
}
