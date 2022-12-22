package com.example.db_cw_backend.transfer;

import com.example.db_cw_backend.model.CityServiceEntity;
import com.example.db_cw_backend.model.QuarterEntity;
import lombok.Data;

import java.io.Serializable;

@Data
public class ServiceTeamDto implements Serializable {
    private Long id;
    private Float rate;
    private Long quarterId;
    private Long cityServiceId;
}
