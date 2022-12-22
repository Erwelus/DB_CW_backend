package com.example.db_cw_backend.transfer;

import com.example.db_cw_backend.model.ModelEntity;
import com.example.db_cw_backend.model.RouteEntity;
import lombok.Data;

import java.util.List;

@Data
public class QuarterDto {
    private Long id;
    private Integer x;
    private Integer y;
    private String name;
    private Long modelId;
    private List<Long> routeIds;
}
