package fr.eni.encheres2.controller;


import fr.eni.encheres2.dto.ArticleVenduDTO;
import fr.eni.encheres2.dto.RetraitDTO;
import fr.eni.encheres2.entity.ArticleVendu;
import fr.eni.encheres2.entity.Retrait;
import fr.eni.encheres2.repository.ArticleVenduRepository;
import fr.eni.encheres2.repository.RetraitRepository;
import fr.eni.encheres2.service.ArticleVenduService;
import fr.eni.encheres2.service.RetraitService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/articles")
public class ArticleVenduController {


    private final ArticleVenduService articleVenduService;

    private final RetraitService retraitService;

    public ArticleVenduController(ArticleVenduService articleVenduService, RetraitService retraitService) {
        this.articleVenduService = articleVenduService;
        this.retraitService = retraitService;
    }

    @GetMapping
    public String afficherArticles(@RequestParam(required=false) String search, String categorie, Model model) {
        if (search != null && !search.isBlank()) {
            model.addAttribute("listeArticles", articleVenduService.rechercherArticlesVendus(search));
        } else if (categorie != null && !categorie.isBlank()) {
            model.addAttribute("listeArticles", articleVenduService.rechercherArticlesVendusParFiltre(categorie));
        } else {
            model.addAttribute("listeArticles", articleVenduService.consulterArticlesVendusEtat("En cours"));
        }
        return "articles";

    }

    @GetMapping("/{noArticle}")
    public String afficherUnArticle(@PathVariable("noArticle") Long noArticle, Model model) {
        model.addAttribute("article", articleVenduService.consulterArticleVenduParNo(noArticle));
        model.addAttribute("retrait", retraitService.consulterRetraitParId(noArticle));
        return "article";
    }

    @GetMapping("/nouvelArticle")
    // ajouter @AuthenticationPrincipal UtilisateurSpringSecurity user après model
    public String afficherFormulaireCreationArticle(Model model) {
        model.addAttribute("article", new ArticleVenduDTO());
        model.addAttribute("retrait", new RetraitDTO());
        return "nouvelArticle";
    }

    @PostMapping("/nouvelArticle")
    // ajouter @AuthenticationPrincipal UtilisateurSpringSecurity user après model
    public String ajouterUnArticle(@Valid ArticleVenduDTO articleVenduDTO, RetraitDTO retraitDTO, BindingResult bindingResult) {
        articleVenduService.creerArticleVendu(articleVenduDTO);
        retraitService.creerRetrait(retraitDTO);

        if (bindingResult.hasErrors()) {
            return "nouvelArticle";
        }
        return "redirect:/articles";
    }


    @GetMapping("/{noArticle}/modifier")
    public String modifierUnArticleGet(@PathVariable("noArticle") Long noArticle, Model model) {
        model.addAttribute("article", articleVenduService.consulterArticleVenduParNo(noArticle));
        model.addAttribute("retrait", retraitService.consulterRetraitParId(noArticle));
        return "nouvelArticle";
    }


    @GetMapping("/{noArticle}/supprimer")
    public String supprimerUnArticle(@PathVariable("noArticle") Long noArticle, Model model) {
        ArticleVenduDTO articleVenduDTO = articleVenduService.consulterArticleVenduParNo(noArticle);
        RetraitDTO retraitDTO = retraitService.consulterRetraitParId(noArticle);

        model.addAttribute("message", "Etes-vous sûr de vouloir supprimer : " + articleVenduDTO.getNom());
        model.addAttribute("action", "/articles" + noArticle + "/supprimer");
        model.addAttribute("back", "/articles");

        //modal de confirmation
        return "confirmation";
    }

    @PostMapping("/{noArticle}/supprimer")
    public String supprimerUnArticle(@PathVariable("noArticle") Long noArticle) {
        retraitService.supprimerRetrait(noArticle);
        articleVenduService.supprimerArticleVendu(noArticle);
        return "redirect:/articles";
    }

}
