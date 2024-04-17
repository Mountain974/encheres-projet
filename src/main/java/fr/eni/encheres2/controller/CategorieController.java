package fr.eni.encheres2.controller;

import fr.eni.encheres2.dto.CategorieDTO;
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
    public List<CategorieDTO> afficherCategories() {
        return categorieService.consulterCategories();
    }

    @GetMapping("/{noCategorie}")
    public ResponseEntity<CategorieDTO> afficherEnchereParId(@PathVariable @NotNull Long noCategorie) {
        CategorieDTO categorieDTO = categorieService.consulterCategorieParNo(noCategorie);
        if (categorieDTO != null) {
            return ResponseEntity.ok(categorieDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Void> ajouterCategorie(@RequestBody @Valid CategorieDTO categorieDTO) {
        categorieService.creerCategorie(categorieDTO);
        return  ResponseEntity.ok().build();
    }

    @PutMapping("/{noCategorie}")
    public ResponseEntity<Void> modifierCategorie(@PathVariable Long noCategorie, @RequestBody CategorieDTO categorieDTO) {
        categorieDTO.setNoCategorie(noCategorie);
        categorieService.modifierCategorie(categorieDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{noCategorie}")
    public ResponseEntity<Void> supprimerCategorie(@PathVariable Long noCategorie) {
        categorieService.supprimerCategorie(noCategorie);
        return ResponseEntity.ok().build();
    }
}
