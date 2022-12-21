package com.example.db_cw_backend.service;

import com.example.db_cw_backend.model.StreetEntity;
import com.example.db_cw_backend.transfer.StreetDto;

import java.util.List;

public interface StreetService {
    StreetEntity prepareEntity(StreetDto data);
    StreetDto prepareDto(StreetEntity entity, List<String> streetList);
}
