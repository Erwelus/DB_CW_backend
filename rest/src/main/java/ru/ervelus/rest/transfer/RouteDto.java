package ru.ervelus.rest.transfer;

import ru.ervelus.rest.model.ModelEntity;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class RouteDto implements Serializable {
    private Long id;
    private String type;
    private Long modelId;
    private List<Long> streetIds;
    private List<Long> quarterIds;
}
