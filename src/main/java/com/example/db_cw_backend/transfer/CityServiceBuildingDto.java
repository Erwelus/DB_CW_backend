package com.example.db_cw_backend.transfer;

import com.example.db_cw_backend.model.BuildingEntity;
import com.example.db_cw_backend.model.CityServiceEntity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Data
public class CityServiceBuildingDto implements Serializable {
    private Integer serviceId;
    private Integer buildingId;
    private CityServiceEntity cityServiceByServiceId;
    private BuildingEntity buildingByBuildingId;
}
