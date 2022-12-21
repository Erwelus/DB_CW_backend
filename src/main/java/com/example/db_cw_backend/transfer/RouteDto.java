package com.example.db_cw_backend.transfer;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class RouteDto implements Serializable {
    private Integer id;
    private String type;
    private String quarterTo;
    private String quarterFrom;
    private List<String> streets;
}
