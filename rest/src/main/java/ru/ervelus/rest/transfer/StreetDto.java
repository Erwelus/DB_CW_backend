package ru.ervelus.rest.transfer;

import ru.ervelus.rest.model.QuarterEntity;
import ru.ervelus.rest.model.RouteEntity;
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
