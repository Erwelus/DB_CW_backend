package com.example.db_cw_backend.transfer;

import lombok.Data;

import java.io.Serializable;

@Data
public class MaterialBuildingDto implements Serializable {
    private Integer materialId;
    private Integer buildingId;
    private Integer quantity;
}
