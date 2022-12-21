package com.example.db_cw_backend.transfer;

import com.example.db_cw_backend.model.QuarterEntity;
import lombok.Data;

import java.io.Serializable;

@Data
public class QuarterQuarterDto implements Serializable {
    private Integer id;
    private Integer quarter1Id;
    private Integer quarter2Id;
    private QuarterEntity quarter1ByQuarter1Id;
    private QuarterEntity quarter2ByQuarter2Id;
}
