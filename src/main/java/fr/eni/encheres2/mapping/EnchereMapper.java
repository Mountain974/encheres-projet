package fr.eni.encheres2.mapping;

import fr.eni.encheres2.dto.EnchereDto;
import fr.eni.encheres2.entity.Enchere;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class EnchereMapper extends CustomModelMapper implements Mapper<Enchere, EnchereDto> {
    public EnchereMapper(ModelMapper modelMapper) {
        super();
        this.modelMapper = modelMapper;
    }
    @Override
    public Enchere mapToEntity(EnchereDto dto) {
        return modelMapper.map(dto, Enchere.class);
    }
    @Override
    public EnchereDto mapToDto(Enchere entity) {
        return modelMapper.map(entity, EnchereDto.class);
    }
}
