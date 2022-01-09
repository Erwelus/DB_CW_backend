package com.example.db_cw_backend.transfer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
public class CityServiceDto implements Serializable {
    private Integer id;
    private String type;
    private Float price;
}
