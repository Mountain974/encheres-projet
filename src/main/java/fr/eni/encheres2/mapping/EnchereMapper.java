package fr.eni.encheres2.mapping;

import fr.eni.encheres2.dto.EnchereDTO;
import fr.eni.encheres2.entity.Enchere;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class EnchereMapper extends CustomModelMapper implements Mapper<Enchere, EnchereDTO> {
    public EnchereMapper(ModelMapper modelMapper) {
        super();
        this.modelMapper = modelMapper;
    }
    @Override
    public Enchere mapToEntity(EnchereDTO dto) {
        return modelMapper.map(dto, Enchere.class);
    }
    @Override
    public EnchereDTO mapToDto(Enchere entity) {
        return modelMapper.map(entity, EnchereDTO.class);
    }
}
