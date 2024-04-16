package fr.eni.encheres2.service;

import fr.eni.encheres2.dto.ArticleDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ArticleService {

    ArticleDTO consulterArticleVenduParNo(Long noArticle);

    void creerArticleVendu(ArticleDTO articleDTO);

    void modifierArticleVendu(ArticleDTO articleDTO);

    void supprimerArticleVendu(Long noArticle); //supprimer un article

    List<ArticleDTO> consulterArticlesVendusEtat(String etat);

    List<ArticleDTO> rechercherArticlesVendus(String search); //par champs de recherche

    List<ArticleDTO> rechercherArticlesVendusParFiltre(String parametresRecherche);

    List<ArticleDTO> afficherArticlesParUtilisateur(Long noUtilisateur);

}
