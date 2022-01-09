package com.example.db_cw_backend.service;

import com.example.db_cw_backend.model.QuarterQuarterEntity;
import com.example.db_cw_backend.transfer.QuarterQuarterDto;

public interface QuarterQuarterService {
    QuarterQuarterEntity prepareEntity(QuarterQuarterDto data);
    QuarterQuarterDto prepareDto(QuarterQuarterEntity entity);
}
