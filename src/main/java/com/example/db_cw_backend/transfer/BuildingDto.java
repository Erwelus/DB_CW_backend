package com.example.db_cw_backend.transfer;

import com.example.db_cw_backend.model.CityServiceEntity;
import com.example.db_cw_backend.model.ConstructionCrewEntity;
import com.example.db_cw_backend.model.MaterialEntity;
import com.example.db_cw_backend.model.StreetEntity;
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
