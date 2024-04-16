package fr.eni.encheres2.mapping;

import fr.eni.encheres2.dto.CategorieDTO;
import fr.eni.encheres2.entity.Categorie;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class CategorieMapper extends CustomModelMapper implements Mapper<Categorie, CategorieDTO> {
    public CategorieMapper(ModelMapper modelMapper) {
        super();
        this.modelMapper = modelMapper;
    }
    @Override
    public Categorie mapToEntity(CategorieDTO dto) {
        return modelMapper.map(dto, Categorie.class);
    }
    @Override
    public CategorieDTO mapToDto(Categorie entity) {
        return modelMapper.map(entity, CategorieDTO.class);
    }
}
