package fr.eni.encheres2.service;

import fr.eni.encheres2.dto.CategorieDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategorieService {

    List<CategorieDTO> consulterCategories();

    CategorieDTO consulterCategorieParNo(Long noCategorie);

    CategorieDTO creerCategorie(CategorieDTO categorie);

    void supprimerCategorie(Long noCategorie);

    void modifierCategorie(CategorieDTO categorie);

}
