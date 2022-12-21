package com.example.db_cw_backend.transfer;

import com.example.db_cw_backend.model.CommitteeEntity;
import com.example.db_cw_backend.model.ConstructionCrewEntity;
import com.example.db_cw_backend.model.StreetEntity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Data
public class BuildingDto implements Serializable {
    private Integer id;
    private String type;
    private String name;
    private Integer floorNumber;
    private Integer readinessCoefficient;
    private Integer streetId;
    private Integer committeeId;
    private Integer crewId;
    private String StreetName;
    private StreetEntity streetByStreetId;
    private ConstructionCrewEntity constructionCrewByCrewId;
    private CommitteeEntity committeeByCommitteeId;
    private List<String> materialList;
    private List<Integer> quantityList;
    private List<String> serviceList;
}
