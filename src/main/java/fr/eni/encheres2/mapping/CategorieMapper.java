package fr.eni.encheres2.mapping;

import fr.eni.encheres2.dto.CategorieDto;
import fr.eni.encheres2.entity.Categorie;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class CategorieMapper extends CustomModelMapper implements Mapper<Categorie, CategorieDto> {
    public CategorieMapper(ModelMapper modelMapper) {
        super();
        this.modelMapper = modelMapper;
    }
    @Override
    public Categorie mapToEntity(CategorieDto dto) {
        return modelMapper.map(dto, Categorie.class);
    }
    @Override
    public CategorieDto mapToDto(Categorie entity) {
        return modelMapper.map(entity, CategorieDto.class);
    }
}
