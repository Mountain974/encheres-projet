package fr.eni.encheres2.controller;

import fr.eni.encheres2.dto.EnchereDto;
import fr.eni.encheres2.service.EnchereService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
    public List<EnchereDto> afficherEncheres() {
        return enchereService.consulterEncheres();
    }

    @GetMapping("/{noUtilisateur}")
    public ResponseEntity<EnchereDto> afficherEnchereParId(@PathVariable @NotNull Long id) {
        EnchereDto enchereDto = enchereService.consulterEnchereParId(id);
        if (enchereDto != null) {
            return ResponseEntity.ok(enchereDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/creer")
    public ResponseEntity<Void> ajouterEnchere(@RequestBody @Valid EnchereDto enchereDto) {
        enchereService.creerEnchere(enchereDto);
        return  ResponseEntity.ok().build();
    }
}