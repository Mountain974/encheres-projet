package fr.eni.encheres2.mapping;

import fr.eni.encheres2.dto.ArticleVenduDTO;
import fr.eni.encheres2.entity.ArticleVendu;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class ArticleVenduMapper extends CustomModelMapper implements Mapper<ArticleVendu, ArticleVenduDTO>{

    public ArticleVenduMapper(ModelMapper modelMapper) {
        super();
        this.modelMapper = modelMapper;
    }

    @Override
    public ArticleVendu mapToEntity(ArticleVenduDTO dto) {
        return modelMapper.map(dto, ArticleVendu.class);
    }

    @Override
    public ArticleVenduDTO mapToDto(ArticleVendu entity) {
        return modelMapper.map(entity, ArticleVenduDTO.class);
    }
}
