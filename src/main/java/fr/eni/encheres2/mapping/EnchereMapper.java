package fr.eni.encheres2.mapping;

import fr.eni.encheres2.entity.Enchere;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class EnchereMapper extends CustomModelMapper implements Mapper<Enchere, EnchereDTO1> {
    public EnchereMapper(ModelMapper modelMapper) {
        super();
        this.modelMapper = modelMapper;
    }
    @Override
    public Enchere mapToEntity(EnchereDTO1 dto) {
        return modelMapper.map(dto, Enchere.class);
    }
    @Override
    public EnchereDTO1 mapToDto(Enchere entity) {
        return modelMapper.map(entity, EnchereDTO1.class);
    }
}
