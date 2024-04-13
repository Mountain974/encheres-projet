package fr.eni.encheres2.controller;

import fr.eni.encheres2.dto.CategorieDto;
import fr.eni.encheres2.service.CategorieService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategorieController {

    private CategorieService categorieService;

    public CategorieController(CategorieService categorieService){
        this.categorieService = categorieService;
    }

    @GetMapping
    public List<CategorieDto> afficherCategories() {
        return categorieService.consulterCategories();
    }

    @GetMapping("/{noCategorie}")
    public String afficherCategorieParNo(@PathVariable("noCategorie") @NotBlank Long noCategorie, Model model) {
        model.addAttribute("categorie", categorieService.consulterCategorieParNo(noCategorie));
        return "categorie";
    }

    @GetMapping("/nouvelleCategorie")
    public String afficherFormulaireCreationCategorie(Model model) {
        model.addAttribute("article", new CategorieDto());
        return "nouvelCategorie";
    }

    @PostMapping("/creer")
    public String ajouterCategorie(@Valid CategorieDto categorie, BindingResult bindingResult) {
        categorieService.creerCategorie(categorie);

        if (bindingResult.hasErrors()) {
            return "creer";
        }
        return "redirect:/categories";
    }

    @GetMapping("/{noCategorie}/modifier")
    public String getFilmEditForm(@PathVariable("noCategorie") Long noCategorie, Model model) {
        model.addAttribute("categorie", categorieService.consulterCategorieParNo(noCategorie));

        return "creer";
    }

    @GetMapping("/{noCategorie}/supprimer")
    public String supprimerUneCategorie(@PathVariable Long noCategorie, Model model) {

        CategorieDto categorie = categorieService.consulterCategorieParNo(noCategorie);

        model.addAttribute("message", "Êtes vous sur de vouloir supprimer la catégorie : " + categorie.getLibelle());
        model.addAttribute("action", "/categories/" + noCategorie + "/supprimer");
        model.addAttribute("back", "/categories");

        // 2 - on redirige sur une page de confirmation ou l'utilisateur va devoir valider son choix
        return "confirmation";
    }

    /**
     * Est appelé lorsqu'on a validé dans le template "confirmation" qu'on souhaite effectuer la suppression de la catégorie
     * Je vais recupérer un no en paramètre d'url
     */
    @PostMapping("/{noCategorie}/supprimer")
    public String supprimerFilm(@PathVariable Long noCategorie) {

        categorieService.supprimerCategorie(noCategorie);

        return "redirect:/";
    }


}
