package com.example.db_cw_backend.transfer;

import lombok.Data;

@Data
public class MaterialInBuildingDto {
    private Long id;
    private Long materialId;
    private Long buildingId;
    private Long quantity;
}
