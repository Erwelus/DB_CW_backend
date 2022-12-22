package ru.ervelus.rest.transfer;

import lombok.Data;

@Data
public class MaterialInBuildingDto {
    private Long id;
    private Long materialId;
    private Long buildingId;
    private Long quantity;
}
