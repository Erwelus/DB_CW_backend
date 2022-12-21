package com.example.db_cw_backend.transfer;

import com.example.db_cw_backend.model.MaterialEntity;
import lombok.Data;

import java.io.Serializable;

@Data
public class DeliveryServiceDto implements Serializable {
    private Integer id;
    private String name;
    private Float rate;
    private String materialType;
    private Integer materialId;
    private MaterialEntity materialByMaterialId;
}
