package com.example.db_cw_backend.service;

import com.example.db_cw_backend.model.QuarterEntity;
import com.example.db_cw_backend.transfer.QuarterDto;

public interface QuarterService {
    QuarterEntity prepareEntity(QuarterDto data);
    QuarterDto prepareDto(QuarterEntity entity);
}
