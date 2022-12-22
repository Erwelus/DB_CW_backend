package ru.ervelus.rest.converter;

import ru.ervelus.rest.model.ModelEntity;
import ru.ervelus.rest.transfer.ModelDto;
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
