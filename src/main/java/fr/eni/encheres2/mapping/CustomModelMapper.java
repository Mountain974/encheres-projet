package fr.eni.encheres2.mapping;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public abstract class CustomModelMapper {
    protected ModelMapper modelMapper;

    @Autowired
    public final void setModelMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }
}
