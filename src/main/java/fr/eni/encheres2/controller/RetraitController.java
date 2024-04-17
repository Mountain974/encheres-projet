package fr.eni.encheres2.controller;

import fr.eni.encheres2.dto.RetraitDTO;
import fr.eni.encheres2.service.RetraitService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/retraits")
public class RetraitController {

    private RetraitService retraitService;

    public RetraitController(RetraitService retraitService){
        this.retraitService = retraitService;
    }

    @GetMapping("/{noArticle}")
    public ResponseEntity<RetraitDTO> afficherRetraitParId(@PathVariable @NotNull Long noArticle) {
        RetraitDTO retraitDTO = retraitService.consulterRetraitParId(noArticle);
        if (retraitDTO != null) {
            return ResponseEntity.ok(retraitDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Void> ajouterRetrait(@RequestBody @Valid RetraitDTO retraitDTO) {
        retraitService.creerRetrait(retraitDTO);
        return  ResponseEntity.ok().build();
    }

    @PutMapping("/{noArticle}")
    public ResponseEntity<Void> modifierCategorie(@PathVariable Long noArticle, @RequestBody RetraitDTO retraitDTO) {
        retraitDTO.setNoArticle(noArticle);
        retraitService.modifierRetrait(retraitDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{noArticle}")
    public ResponseEntity<Void> supprimerRetrait(@PathVariable Long noArticle) {
        retraitService.supprimerRetrait(noArticle);
        return ResponseEntity.ok().build();
    }
}