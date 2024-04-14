package fr.eni.encheres2.service;

import fr.eni.encheres2.dto.ArticleVenduDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ArticleVenduService {

    ArticleVenduDTO consulterArticleVenduParNo(Long noArticle);

    void creerArticleVendu(ArticleVenduDTO articleVenduDTO);

    void modifierArticleVendu(ArticleVenduDTO articleVenduDTO);

    void supprimerArticleVendu(Long noArticle); //supprimer un article

    List<ArticleVenduDTO> consulterArticlesVendusEtat(String etat);

    List<ArticleVenduDTO> rechercherArticlesVendus(String search); //par champs de recherche

    List<ArticleVenduDTO> rechercherArticlesVendusParFiltre(String parametresRecherche);

}
