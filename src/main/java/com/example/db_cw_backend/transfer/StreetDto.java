package com.example.db_cw_backend.transfer;

import lombok.Data;

import java.io.Serializable;

@Data
public class StreetDto implements Serializable {
    private Integer id;
    private String name;
    private Integer quarterId;
}
