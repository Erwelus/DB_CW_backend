package com.example.db_cw_backend.transfer;

import com.example.db_cw_backend.model.CityServiceEntity;
import com.example.db_cw_backend.model.QuarterEntity;
import lombok.Data;

import java.io.Serializable;

@Data
public class ServiceTeamDto implements Serializable {
    private Integer id;
    private Float rate;
    private Integer quarterId;
    private Integer cityServiceId;
    private QuarterEntity quarterByQuarterId;
    private CityServiceEntity cityServiceByServiceId;
    private String serviceType;
    private String quarterName;
}
