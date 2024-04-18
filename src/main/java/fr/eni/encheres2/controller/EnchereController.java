package fr.eni.encheres2.controller;

import fr.eni.encheres2.dto.EnchereDTO;
import fr.eni.encheres2.service.EnchereService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/encheres")
public class EnchereController {

    private EnchereService enchereService;

    public EnchereController(EnchereService enchereService) {
        this.enchereService = enchereService;
    }

    @GetMapping
    public List<EnchereDTO> afficherEncheres() {
        return enchereService.consulterEncheres();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnchereDTO> afficherEnchereParId(@PathVariable @NotNull Long id) {
        EnchereDTO enchereDto = enchereService.consulterEnchereParId(id);
        if (enchereDto != null) {
            return ResponseEntity.ok(enchereDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/creer")
    public ResponseEntity<Void> ajouterEnchere(@RequestBody @Valid EnchereDTO enchereDTO) {
        enchereService.creerEnchere(enchereDTO);
        return ResponseEntity.ok().build();
    }
}