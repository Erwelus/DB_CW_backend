package com.example.db_cw_backend.converter;

import com.example.db_cw_backend.model.ModelEntity;
import com.example.db_cw_backend.transfer.ModelDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ModelEntityToDto implements Converter<ModelEntity, ModelDto> {
    @Override
    public ModelDto convert(ModelEntity source) {
        ModelDto dto = new ModelDto();
        dto.setId(source.getId());
        dto.setName(source.getName());
        return dto;
    }
}
