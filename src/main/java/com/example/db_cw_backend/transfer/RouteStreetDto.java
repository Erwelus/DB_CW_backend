package com.example.db_cw_backend.transfer;

import com.example.db_cw_backend.model.RouteEntity;
import com.example.db_cw_backend.model.StreetEntity;
import lombok.Data;

import java.io.Serializable;

@Data
public class RouteStreetDto implements Serializable {
    private Integer routeId;
    private Integer streetId;
    private RouteEntity routeByRouteId;
    private StreetEntity streetByStreetId;
}
