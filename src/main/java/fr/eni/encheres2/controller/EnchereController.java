package fr.eni.encheres2.controller;

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

    public EnchereController(EnchereService enchereService){
        this.enchereService = enchereService;
    }

    @GetMapping
    public List<EnchereDTO1> afficherEncheres() {
        return enchereService.consulterEncheres();
    }

    @GetMapping("/{noUtilisateur}")
    public ResponseEntity<EnchereDTO1> afficherEnchereParId(@PathVariable @NotNull Long id) {
        EnchereDTO1 enchereDto = enchereService.consulterEnchereParId(id);
        if (enchereDto != null) {
            return ResponseEntity.ok(enchereDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/creer")
    public ResponseEntity<Void> ajouterEnchere(@RequestBody @Valid EnchereDTO1 enchereDTO) {
        enchereService.creerEnchere(enchereDTO);
        return  ResponseEntity.ok().build();
    }
}