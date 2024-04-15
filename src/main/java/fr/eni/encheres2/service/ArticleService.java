package fr.eni.encheres2.service;

import fr.eni.encheres2.dto.ArticleDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ArticleService {
    List<ArticleDTO> afficherArticlesParUtilisateur(Long noUtilisateur);
}
