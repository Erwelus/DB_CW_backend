package com.example.db_cw_backend.transfer;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Data
public class CityServiceBuildingDto implements Serializable {
    private Integer serviceId;
    private Integer buildingId;
}
