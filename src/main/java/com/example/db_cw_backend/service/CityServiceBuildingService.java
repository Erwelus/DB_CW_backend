package com.example.db_cw_backend.service;

import com.example.db_cw_backend.model.BuildingEntity;
import com.example.db_cw_backend.model.CityServiceBuildingEntity;
import com.example.db_cw_backend.model.CityServiceEntity;
import com.example.db_cw_backend.model.QuarterEntity;
import com.example.db_cw_backend.transfer.CityServiceBuildingDto;
import com.example.db_cw_backend.transfer.CityServiceDto;
import com.example.db_cw_backend.transfer.QuarterDto;

public interface CityServiceBuildingService {
    CityServiceBuildingEntity prepareEntity(CityServiceBuildingDto data);
    CityServiceBuildingDto prepareDto(CityServiceBuildingEntity entity);
}
