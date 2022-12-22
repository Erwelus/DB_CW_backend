package com.example.db_cw_backend.transfer;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class MaterialDto implements Serializable {
    private Long id;
    private String type;
    private Integer quantity;
    private Float price;
    private Long modelId;
    private List<Long> buildingIds;
}
