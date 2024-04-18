package fr.eni.encheres2.controller;

import fr.eni.encheres2.dto.ArticleDTO;
import fr.eni.encheres2.dto.EnchereDTO;
import fr.eni.encheres2.dto.UtilisateurDTO;
import fr.eni.encheres2.repository.UtilisateurRepository;
import fr.eni.encheres2.service.ArticleService;
import fr.eni.encheres2.service.EnchereService;
import fr.eni.encheres2.service.implementationJPA.UtilisateurServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/utilisateurs")
public class UtilisateurController {

    private final UtilisateurServiceImpl utilisateurService;
    private final EnchereService enchereService;
    private final ArticleService articleService;

    @Autowired
    public UtilisateurController(UtilisateurRepository userRepository, UtilisateurServiceImpl utilisateurService, EnchereService enchereService, ArticleService articleService) {
        this.utilisateurService = utilisateurService;
        this.enchereService = enchereService;
        this.articleService = articleService;
    }

    @PostMapping("/register")
    public void creerUtilisateur(@RequestBody @Valid UtilisateurDTO user) {
        utilisateurService.creerUtilisateur(user);
    }


    @GetMapping
    public List<UtilisateurDTO> afficherTousLesUtilisateurs() {
        return utilisateurService.tousLesUtilisateurs();
    }

    @GetMapping("/{noUtilisateur}")
    public ResponseEntity<UtilisateurDTO> afficherUnUtilisateur(@PathVariable Long noUtilisateur) {
        UtilisateurDTO userDTO = utilisateurService.trouverUtilisateurParId(noUtilisateur);
        if (userDTO != null) {
            return ResponseEntity.ok(userDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{noUtilisateur}")
    public ResponseEntity<Void> modifierUtilisateur(@PathVariable Long noUtilisateur, @RequestBody UtilisateurDTO userDTO) {
        userDTO.setNoUtilisateur(noUtilisateur);
        utilisateurService.modifierUtilisateur(userDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{noUtilisateur}")
    public ResponseEntity<Void> supprimerUtilisateur(@PathVariable Long noUtilisateur) {
        utilisateurService.supprimerUtilisateur(noUtilisateur);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{noUtilisateur}/encheres")
    public List<EnchereDTO> afficherEncheres(@PathVariable Long noUtilisateur) {
        return enchereService.afficherEncheresParUtilisateur(noUtilisateur);
    }

    @GetMapping("/{noUtilisateur}/ventes")
    public List<ArticleDTO> afficherVentes(@PathVariable Long noUtilisateur) {
        return articleService.afficherArticlesParUtilisateur(noUtilisateur);
    }
}
