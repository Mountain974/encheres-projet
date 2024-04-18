package fr.eni.encheres2.service;

import fr.eni.encheres2.dto.EnchereDTO;
import fr.eni.encheres2.entity.Article;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EnchereService {

    List<EnchereDTO> consulterEncheres();

    EnchereDTO consulterEnchereParId(Long id);

    EnchereDTO consulterMeilleurEncherePourUnArticle(Long noArticle);

    EnchereDTO creerEnchere(EnchereDTO enchere);

    List<EnchereDTO> afficherEncheresParUtilisateur(Long noUtilisateur);

}
