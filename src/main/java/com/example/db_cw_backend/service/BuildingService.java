package com.example.db_cw_backend.service;

import com.example.db_cw_backend.model.BuildingEntity;
import com.example.db_cw_backend.transfer.BuildingDto;

import java.util.List;
import java.util.Map;


public interface BuildingService {
    BuildingEntity prepareEntity(BuildingDto data);
    BuildingDto prepareDto(BuildingEntity entity, List<String> materialList, List<Integer> quantityList, List<String> serviceList);
}
