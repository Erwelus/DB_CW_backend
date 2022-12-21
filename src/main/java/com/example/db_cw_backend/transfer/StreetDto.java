package com.example.db_cw_backend.transfer;

import com.example.db_cw_backend.model.QuarterEntity;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class StreetDto implements Serializable {
    private Integer id;
    private String name;
    private String quarterName;
    private String oldName;
    private Integer quarterId;
    private QuarterEntity quarterByQuarterId;
    private List<String> streetList;
}
