package com.example.db_cw_backend.transfer;

import lombok.Data;

import java.io.Serializable;

@Data
public class RouteDto implements Serializable {
    private Integer id;
    private String type;
}
