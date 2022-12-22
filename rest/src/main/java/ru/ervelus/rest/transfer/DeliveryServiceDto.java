package ru.ervelus.rest.transfer;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class DeliveryServiceDto implements Serializable {
    private Long id;
    private String name;
    private Float rate;
    private Long materialId;
    private List<Long> crewIds;
}
