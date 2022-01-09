package com.example.db_cw_backend.service;

import com.example.db_cw_backend.model.StreetStreetEntity;
import com.example.db_cw_backend.transfer.StreetStreetDto;

public interface StreetStreetService {
    StreetStreetEntity prepareEntity(StreetStreetDto data);
    StreetStreetDto prepareDto(StreetStreetEntity entity);
}
