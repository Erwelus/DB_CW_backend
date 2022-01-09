package com.example.db_cw_backend.transfer;

import lombok.Data;

import java.io.Serializable;

@Data
public class QuarterQuarterDto implements Serializable {
    private Integer id;
    private Integer quarter1Id;
    private Integer quarter2Id;
}
