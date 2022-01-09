package com.example.db_cw_backend.transfer;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Data
public class BuildingDto implements Serializable {
    private Integer id;
    private String type;
    private String name;
    private Integer floorNumber;
    private Integer readinessCoefficient;
    private Integer streetId;
    private Integer committeeId;
    private Integer crewId;
}
