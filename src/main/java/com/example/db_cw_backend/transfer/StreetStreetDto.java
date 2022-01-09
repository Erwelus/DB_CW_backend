package com.example.db_cw_backend.transfer;

import lombok.Data;

import java.io.Serializable;

@Data
public class StreetStreetDto implements Serializable {
    private Integer id;
    private Integer street1Id;
    private Integer street2Id;
}
