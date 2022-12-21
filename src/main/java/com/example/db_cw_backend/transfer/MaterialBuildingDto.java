package com.example.db_cw_backend.transfer;

import com.example.db_cw_backend.model.BuildingEntity;
import com.example.db_cw_backend.model.MaterialEntity;
import lombok.Data;

import java.io.Serializable;

@Data
public class MaterialBuildingDto implements Serializable {
    private Integer materialId;
    private Integer buildingId;
    private Integer quantity;
    private MaterialEntity materialByMaterialId;
    private BuildingEntity buildingByBuildingId;
}
