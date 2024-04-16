package fr.eni.encheres2.service.implementationJPA;

import fr.eni.encheres2.dto.ArticleDTO;
import fr.eni.encheres2.mapping.ArticleMapper;
import fr.eni.encheres2.entity.Article;
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
    private final ArticleMapper modelMapper;
    private final ArticleRepository articleRepository;

    @Autowired
    public ArticleServiceImpl(ArticleMapper modelMapper, ArticleRepository articleRepository) {
        this.modelMapper = modelMapper;
        this.articleRepository = articleRepository;

    }

    @Override
    public ArticleDTO consulterArticleVenduParNo(Long noArticle) {
        Article article = articleRepository.findById(noArticle).
                orElseThrow(() -> {throw new ResponseStatusException(HttpStatus.NOT_FOUND, "l'article n'existe pas");});
        return modelMapper.mapToDto(article);
    }


    @Override
    public void creerArticleVendu(@Valid @NotNull ArticleDTO articleDTO) {
        modelMapper.mapToDto(articleRepository.save(modelMapper.mapToEntity(articleDTO)));
    }

    @Override
    public void modifierArticleVendu(ArticleDTO articleDTO) {
        Article article = modelMapper.mapToEntity(articleDTO);
        if (articleRepository.existsById(article.getNoArticle())){
            articleRepository.save(article);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "la retrait n'existe pas");
        }

    }

    @Override
    public void supprimerArticleVendu(@NotNull Long noArticle) {
        if (articleRepository.findById(noArticle).isPresent()){
            articleRepository.deleteById(noArticle);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "l'article n'existe pas");
        }
    }

    /*@Override
    public List<ArticleDTO> consulterArticlesVendusEtat(String etat) {
        List<Article> articleVendu = articleRepository.findByEtat(etat);
        if (articleVendu.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Pas d'articles");
        }
        return articleVendu.stream()
                .map(article -> modelMapper.mapToDto(article))
                .collect(Collectors.toList());
    }

    @Override
    public List<ArticleDTO> rechercherArticlesVendus(String search) {
        List<Article> articleVendu = articleRepository.searchByNom(search);
        if (articleVendu.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Pas d'articles");
        }
        return articleVendu.stream()
                .map(article -> modelMapper.mapToDto(article))
                .collect(Collectors.toList());
    }

    @Override
    public List<ArticleDTO> rechercherArticlesVendusParFiltre(String parametresRecherche) {
        return List.of();
    }

    @Override
    public List<ArticleDTO> rechercherArticlesVendusParFiltre(String categorie) {
        List<Article> articleVendu = articleRepository.searchByCategorie(categorie);
        if (articleVendu.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Pas d'articles");
        }
        return articleVendu.stream()
                .map(article -> modelMapper.mapToDto(article))
                .collect(Collectors.toList());
    }*/

    @Override
    public List<ArticleDTO> consulterArticlesVendusEtat(String etat) {
        return List.of();
    }

    @Override
    public List<ArticleDTO> rechercherArticlesVendus(String search) {
        return List.of();
    }

    @Override
    public List<ArticleDTO> rechercherArticlesVendusParFiltre(String parametresRecherche) {
        return List.of();
    }

    @Override
    public List<ArticleDTO> afficherArticlesParUtilisateur(Long noUtilisateur) {
        return List.of();
    }

}
