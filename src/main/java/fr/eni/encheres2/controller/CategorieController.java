package fr.eni.encheres2.controller;

import fr.eni.encheres2.dto.CategorieDto;
import fr.eni.encheres2.service.CategorieService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<CategorieDto> afficherCategorieParNo(@PathVariable("noCategorie") @NotNull Long noCategorie) {
        CategorieDto categorieDto = categorieService.consulterCategorieParNo(noCategorie);
        if (categorieDto != null) {
            return ResponseEntity.ok(categorieDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/creer")
    public ResponseEntity<CategorieDto> ajouterCategorie(@Valid CategorieDto categorie) {
        CategorieDto categorieDto = categorieService.creerCategorie(categorie);

        if (categorieDto != null) {
            return ResponseEntity.ok(categorieDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{noCategorie}/modifier")
    public ResponseEntity<CategorieDto> modifierCategorie(@PathVariable @NotNull Long noCategorie, @RequestBody CategorieDto categorieDto) {
        categorieDto.setNoCategorie(noCategorie);
        categorieService.modifierCategorie(categorieDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{noCategorie}/supprimer")
    public ResponseEntity<CategorieDto> supprimerUneCategorie(@PathVariable Long noCategorie) {
        categorieService.supprimerCategorie(noCategorie);
        return ResponseEntity.ok().build();
    }
}
