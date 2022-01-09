package com.example.db_cw_backend.transfer;

import lombok.Data;

import java.io.Serializable;

@Data
public class ServiceTeamDto implements Serializable {
    private Integer id;
    private Float rate;
    private Integer quarterId;
    private Integer cityServiceId;
}
