package com.example.db_cw_backend.transfer;

import lombok.Data;

import java.io.Serializable;

@Data
public class DeliveryServiceConstructionCrewDto implements Serializable {
    private Integer deliveryServiceId;
    private Integer constructionCrewId;
}
