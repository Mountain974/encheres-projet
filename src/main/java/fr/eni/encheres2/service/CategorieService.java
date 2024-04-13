package fr.eni.encheres2.service;

import fr.eni.encheres2.dto.CategorieDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategorieService {

    List<CategorieDto> consulterCategories();

    CategorieDto consulterCategorieParNo(Long noCategorie);

    CategorieDto creerCategorie(CategorieDto categorie);

    void supprimerCategorie(Long noCategorie);

    void modifierCategorie(CategorieDto categorie);

}
