package fr.eni.encheres2.mapping;

import fr.eni.encheres2.dto.ArticleDTO;
import fr.eni.encheres2.entity.Article;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class ArticleMapper extends CustomModelMapper implements Mapper<Article, ArticleDTO>{

    public ArticleMapper(ModelMapper modelMapper) {
        super();
        this.modelMapper = modelMapper;
    }

    @Override
    public Article mapToEntity(ArticleDTO dto) {
        return modelMapper.map(dto, Article.class);
    }

    @Override
    public ArticleDTO mapToDto(Article entity) {
        return modelMapper.map(entity, ArticleDTO.class);
    }
}
