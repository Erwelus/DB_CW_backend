package com.example.db_cw_backend.transfer;

import com.example.db_cw_backend.model.QuarterEntity;
import com.example.db_cw_backend.model.RouteEntity;
import lombok.Data;

import java.io.Serializable;

@Data
public class RouteQuartersDto implements Serializable {
    private Integer routeId;
    private Integer quarterFrom;
    private Integer quarterTo;
    private RouteEntity routeByRouteId;
    private QuarterEntity quarterByQuarterFrom;
    private QuarterEntity quarterByQuarterTo;
}
