package com.example.db_cw_backend.transfer;

import com.example.db_cw_backend.model.QuarterEntity;
import com.example.db_cw_backend.model.RouteEntity;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class StreetDto implements Serializable {
    private Long id;
    private String name;
    private Long quarterId;
    private List<Long> routeIds;
}
