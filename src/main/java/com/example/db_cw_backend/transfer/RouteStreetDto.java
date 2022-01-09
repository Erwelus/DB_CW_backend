package com.example.db_cw_backend.transfer;

import lombok.Data;

import java.io.Serializable;

@Data
public class RouteStreetDto implements Serializable {
    private Integer routeId;
    private Integer streetId;
}
