package com.example.db_cw_backend.transfer;

import com.example.db_cw_backend.model.StreetEntity;
import lombok.Data;

import java.io.Serializable;

@Data
public class StreetStreetDto implements Serializable {
    private Integer id;
    private Integer street1Id;
    private Integer street2Id;
    private StreetEntity street1ByStreet1Id;
    private StreetEntity street2ByStreet2Id;
}
