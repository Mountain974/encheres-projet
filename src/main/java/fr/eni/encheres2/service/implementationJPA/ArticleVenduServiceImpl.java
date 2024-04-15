package fr.eni.encheres2.service.implementationJPA;


import fr.eni.encheres2.dto.ArticleVenduDTO;
import fr.eni.encheres2.dto.RetraitDTO;
import fr.eni.encheres2.mapping.ArticleVenduMapper;
import fr.eni.encheres2.entity.ArticleVendu;
import fr.eni.encheres2.entity.Retrait;
import fr.eni.encheres2.repository.ArticleVenduRepository;
import fr.eni.encheres2.service.ArticleVenduService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class ArticleVenduServiceImpl implements ArticleVenduService {
    private final ArticleVenduMapper modelMapper;
    private final ArticleVenduRepository articleVenduRepository;

    @Autowired
    public ArticleVenduServiceImpl(ArticleVenduMapper modelMapper, ArticleVenduRepository articleVenduRepository) {
        this.modelMapper = modelMapper;
        this.articleVenduRepository = articleVenduRepository;

    }

    @Override
    public ArticleVenduDTO consulterArticleVenduParNo(Long noArticle) {
        ArticleVendu articleVendu = articleVenduRepository.findById(noArticle).
                orElseThrow(() -> {throw new ResponseStatusException(HttpStatus.NOT_FOUND, "l'article n'existe pas");});
        return modelMapper.mapToDto(articleVendu);
    }


    @Override
    public void creerArticleVendu(@Valid @NotNull ArticleVenduDTO articleVenduDTO) {
        modelMapper.mapToDto(articleVenduRepository.save(modelMapper.mapToEntity(articleVenduDTO)));
    }

    @Override
    public void modifierArticleVendu(ArticleVenduDTO articleVenduDTO) {
        ArticleVendu articleVendu = modelMapper.mapToEntity(articleVenduDTO);
        if (articleVenduRepository.existsById(articleVendu.getNoArticle())){
            articleVenduRepository.save(articleVendu);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "la retrait n'existe pas");
        }

    }

    @Override
    public void supprimerArticleVendu(@NotNull Long noArticle) {
        if (articleVenduRepository.findById(noArticle).isPresent()){
            articleVenduRepository.deleteById(noArticle);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "l'article n'existe pas");
        }
    }

    @Override
    public List<ArticleVenduDTO> consulterArticlesVendusEtat(String etat) {
        List<ArticleVendu> articleVendu = articleVenduRepository.findByEtat(etat);
        if (articleVendu.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Pas d'articles");
        }
        return articleVendu.stream()
                .map(article -> modelMapper.mapToDto(article))
                .collect(Collectors.toList());
    }

    @Override
    public List<ArticleVenduDTO> rechercherArticlesVendus(String search) {
        List<ArticleVendu> articleVendu = articleVenduRepository.searchByNom(search);
        if (articleVendu.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Pas d'articles");
        }
        return articleVendu.stream()
                .map(article -> modelMapper.mapToDto(article))
                .collect(Collectors.toList());
    }

    @Override
    public List<ArticleVenduDTO> rechercherArticlesVendusParFiltre(String categorie) {
        List<ArticleVendu> articleVendu = articleVenduRepository.searchByCategorie(categorie);
        if (articleVendu.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Pas d'articles");
        }
        return articleVendu.stream()
                .map(article -> modelMapper.mapToDto(article))
                .collect(Collectors.toList());
    }

}
