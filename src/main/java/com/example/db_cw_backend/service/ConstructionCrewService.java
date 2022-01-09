package com.example.db_cw_backend.service;

import com.example.db_cw_backend.model.ConstructionCrewEntity;
import com.example.db_cw_backend.transfer.ConstructionCrewDto;

public interface ConstructionCrewService {
    ConstructionCrewEntity prepareEntity(ConstructionCrewDto data);
    ConstructionCrewDto prepareDto(ConstructionCrewEntity entity);
}
