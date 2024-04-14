package fr.eni.encheres2.service.implementationJPA;

import fr.eni.encheres2.dto.ArticleDTO;
import fr.eni.encheres2.entity.Article;
import fr.eni.encheres2.mapping.ArticleMapper;
import fr.eni.encheres2.repository.ArticleRepository;
import fr.eni.encheres2.service.ArticleService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArticleServiceImpl implements ArticleService {

    private final ArticleMapper modelMapper = new ArticleMapper();
    private final ArticleRepository articleRepository;

    @Autowired
    public ArticleServiceImpl(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;

    }

    @Override
    public ArticleDTO consulterArticleParNo(Long noArticle) {
        Article article = articleRepository.findById(noArticle).
                orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "l'article n'existe pas"));
        return modelMapper.mapToDto(article);
    }


    @Override
    public void creerArticle(@Valid @NotNull ArticleDTO articleDTO) {
        modelMapper.mapToDto(articleRepository.save(modelMapper.mapToEntity(articleDTO)));
    }

    @Override
    public void modifierArticle(ArticleDTO articleDTO) {
        Article article = modelMapper.mapToEntity(articleDTO);
        if (articleRepository.existsById(article.getNoArticle())) {
            articleRepository.save(article);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "la retrait n'existe pas");
        }

    }

    @Override
    public void supprimerArticle(@NotNull Long noArticle) {
        if (articleRepository.findById(noArticle).isPresent()) {
            articleRepository.deleteById(noArticle);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "l'article n'existe pas");
        }
    }

    @Override
    public List<ArticleDTO> consulterArticlesVendusEtat(String etat) {
        List<Article> article = articleRepository.findByEtat(etat);
        if (article.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Pas d'articles");
        }
        return article.stream()
                .map(modelMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ArticleDTO> rechercherArticlesVendus(String search) {
        List<Article> article = articleRepository.searchByNom(search);
        if (article.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Pas d'articles");
        }
        return article.stream()
                .map(modelMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ArticleDTO> rechercherArticlesVendusParFiltre(String categorie) {
        List<Article> article = articleRepository.searchByCategorie(categorie);
        if (article.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Pas d'articles");
        }
        return article.stream()
                .map(modelMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ArticleDTO> afficherArticlesParUtilisateur(Long noUtilisateur) {
        return List.of();
    }

}
