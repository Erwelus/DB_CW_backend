package com.example.db_cw_backend.service;

import com.example.db_cw_backend.model.StreetEntity;
import com.example.db_cw_backend.transfer.StreetDto;

public interface StreetService {
    StreetEntity prepareEntity(StreetDto data);
    StreetDto prepareDto(StreetEntity entity);
}
