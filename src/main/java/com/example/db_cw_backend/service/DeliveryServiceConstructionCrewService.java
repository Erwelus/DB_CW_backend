package com.example.db_cw_backend.service;

import com.example.db_cw_backend.model.DeliveryServiceConstructionCrewEntity;
import com.example.db_cw_backend.transfer.DeliveryServiceConstructionCrewDto;

public interface DeliveryServiceConstructionCrewService {
    DeliveryServiceConstructionCrewEntity prepareEntity(DeliveryServiceConstructionCrewDto data);
    DeliveryServiceConstructionCrewDto prepareDto(DeliveryServiceConstructionCrewEntity entity);
}
