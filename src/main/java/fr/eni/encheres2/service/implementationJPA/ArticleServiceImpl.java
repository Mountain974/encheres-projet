package fr.eni.encheres2.service.implementationJPA;

import fr.eni.encheres2.dto.ArticleDTO;
import fr.eni.encheres2.service.ArticleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    //    Méthode à compléter lorsque la classe Article sera développée
    @Override
    public List<ArticleDTO> afficherArticlesParUtilisateur(Long noUtilisateur) {
        return List.of();
    }
}
