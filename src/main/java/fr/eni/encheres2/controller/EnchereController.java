package fr.eni.encheres2.controller;

import fr.eni.encheres2.dto.EnchereDto;
import fr.eni.encheres2.service.EnchereService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
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

    @GetMapping("/{id}")
    public String afficherEnchereParId(@PathVariable("id") @NotBlank Long id, Model model) {
        model.addAttribute("enchere", enchereService.consulterEnchereParId(id));
        return "enchere";
    }

    @GetMapping("/nouvelleEnchere")
    public String afficherFormulaireCreationEnchere(Model model) {
        model.addAttribute("enchere", new EnchereDto());
        return "nouvelleEnchere";
    }

    @PostMapping("/creer")
    public String ajouterEnchere(@Valid EnchereDto enchere, BindingResult bindingResult) {
        enchereService.creerEnchere(enchere);

        if (bindingResult.hasErrors()) {
            return "creer";
        }
        return "redirect:/encheres";
    }
}
