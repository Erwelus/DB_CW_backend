package com.example.db_cw_backend.service.impl;

import com.example.db_cw_backend.model.BuildingEntity;
import com.example.db_cw_backend.service.BuildingService;
import com.example.db_cw_backend.transfer.BuildingDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BuildingServiceImpl implements BuildingService {


    @Override
    public BuildingEntity prepareEntity(BuildingDto data) {
        BuildingEntity entity = new BuildingEntity();
        entity.setId(data.getId());
        entity.setName(data.getName());
        entity.setFloorNumber(data.getFloorNumber());
        entity.setReadinessCoefficient(data.getReadinessCoefficient());
        entity.setType(data.getType());
        entity.setStreetId(data.getStreetId());
        entity.setCommitteeId(data.getCommitteeId());
        entity.setCrewId(data.getCrewId());
        entity.setCommitteeByCommitteeId(data.getCommitteeByCommitteeId());
        entity.setConstructionCrewByCrewId(data.getConstructionCrewByCrewId());
        entity.setStreetByStreetId(data.getStreetByStreetId());
        return entity;
    }

    @Override
    public BuildingDto prepareDto(BuildingEntity entity, List<String> materialList, List<Integer> quantityList, List<String> serviceList) {
        BuildingDto response = new BuildingDto();
        response.setId(entity.getId());
        response.setName(entity.getName());
        response.setType(entity.getType());
        response.setFloorNumber(entity.getFloorNumber());
        response.setReadinessCoefficient(entity.getReadinessCoefficient());
        response.setStreetId(entity.getStreetId());
        response.setCrewId(entity.getCrewId());
        response.setCommitteeId(entity.getCommitteeId());
        response.setCommitteeByCommitteeId(entity.getCommitteeByCommitteeId());
        response.setConstructionCrewByCrewId(entity.getConstructionCrewByCrewId());
        response.setStreetByStreetId(entity.getStreetByStreetId());
        response.setMaterialList(materialList);
        response.setQuantityList(quantityList);
        response.setServiceList(serviceList);
        return response;
    }
}
