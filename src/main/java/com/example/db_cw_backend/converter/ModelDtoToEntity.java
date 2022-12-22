package com.example.db_cw_backend.converter;

import com.example.db_cw_backend.model.ModelEntity;
import com.example.db_cw_backend.transfer.ModelDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ModelDtoToEntity implements Converter<ModelDto, ModelEntity> {
    @Override
    public ModelEntity convert(ModelDto source) {
        ModelEntity entity = new ModelEntity();
        entity.setId(source.getId());
        entity.setName(source.getName());
        return entity;
    }
}
