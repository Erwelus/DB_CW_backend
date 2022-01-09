package com.example.db_cw_backend.transfer;

import lombok.Data;

import java.io.Serializable;

@Data
public class MaterialDto implements Serializable {
    private Integer id;
    private String type;
    private Integer quantity;
    private Float price;
}
