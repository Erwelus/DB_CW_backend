package ru.ervelus.rest.transfer;

import ru.ervelus.rest.model.ModelEntity;
import ru.ervelus.rest.model.RouteEntity;
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
