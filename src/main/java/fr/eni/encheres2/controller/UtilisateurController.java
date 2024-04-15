package fr.eni.encheres2.controller;

import fr.eni.encheres2.dto.UtilisateurDTO;
import fr.eni.encheres2.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/utilisateurs")
public class UtilisateurController {

    private final UtilisateurService utilisateurService;

    @Autowired
    public UtilisateurController(UtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }

    @GetMapping
    public List<UtilisateurDTO> afficherTousLesUtilisateurs() {
        return utilisateurService.tousLesUtilisateurs();
    }

    @GetMapping("/{noUtilisateur}")
    public ResponseEntity<UtilisateurDTO> afficherUnUtilisateur(@PathVariable Long noUtilisateur) {
        UtilisateurDTO userDTO = utilisateurService.trouverUtilisateur(noUtilisateur);
        if (userDTO != null) {
            return ResponseEntity.ok(userDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Void> creerUtilisateur(@RequestBody UtilisateurDTO userDTO) {
        utilisateurService.creerUtilisateur(userDTO);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> modifierUtilisateur(@PathVariable Long id, @RequestBody UtilisateurDTO userDTO) {
        userDTO.setNoUtilisateur(id);
        utilisateurService.modifierUtilisateur(userDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerUtilisateur(@PathVariable Long id) {
        utilisateurService.supprimerUtilisateur(id);
        return ResponseEntity.ok().build();
    }

}
