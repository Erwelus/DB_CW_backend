package com.example.db_cw_backend.service;

import com.example.db_cw_backend.model.DeliveryServiceEntity;
import com.example.db_cw_backend.transfer.DeliveryServiceDto;

public interface DeliveryServiceService {
    DeliveryServiceEntity prepareEntity(DeliveryServiceDto data);
    DeliveryServiceDto prepareDto(DeliveryServiceEntity entity);
}
