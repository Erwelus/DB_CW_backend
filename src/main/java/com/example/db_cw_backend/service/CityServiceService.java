package com.example.db_cw_backend.service;

import com.example.db_cw_backend.model.CityServiceEntity;
import com.example.db_cw_backend.model.QuarterEntity;
import com.example.db_cw_backend.transfer.CityServiceDto;
import com.example.db_cw_backend.transfer.QuarterDto;

public interface CityServiceService {
    CityServiceEntity prepareEntity(CityServiceDto data);
    CityServiceDto prepareDto(CityServiceEntity entity);
}
