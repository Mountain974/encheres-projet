package fr.eni.encheres2.controller;


import fr.eni.encheres2.dto.ArticleDTO;
import fr.eni.encheres2.dto.RetraitDTO;
import fr.eni.encheres2.service.implementationJPA.ArticleServiceImpl;
import fr.eni.encheres2.service.implementationJPA.RetraitServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/articles")
public class ArticleController {

    private final ArticleServiceImpl articleService;
    private final RetraitServiceImpl retraitService;

    @Autowired
    public ArticleController(ArticleServiceImpl articleService, RetraitServiceImpl retraitService) {
        this.articleService = articleService;
        this.retraitService = retraitService;
    }

    @GetMapping
    public String afficherArticles(@RequestParam(required = false) String search, String categorie, Model model) {
        if (search != null && !search.isBlank()) {
            model.addAttribute("listeArticles", articleService.rechercherArticlesVendus(search));
        } else if (categorie != null && !categorie.isBlank()) {
            model.addAttribute("listeArticles", articleService.rechercherArticlesVendusParFiltre(categorie));
        } else {
            model.addAttribute("listeArticles", articleService.consulterArticlesVendusEtat("En cours"));
        }
        return "articles";

    }

    @GetMapping("/{noArticle}")
    public String afficherUnArticle(@PathVariable("noArticle") Long noArticle, Model model) {
        model.addAttribute("article", articleService.consulterArticleParNo(noArticle));
        model.addAttribute("retrait", retraitService.consulterRetraitParId(noArticle));
        return "article";
    }

    @GetMapping("/nouvelArticle")
    // ajouter @AuthenticationPrincipal UtilisateurSpringSecurity user après model
    public String afficherFormulaireCreationArticle(Model model) {
        model.addAttribute("article", new ArticleDTO());
        model.addAttribute("retrait", new RetraitDTO());
        return "nouvelArticle";
    }

    @PostMapping("/nouvelArticle")
    // ajouter @AuthenticationPrincipal UtilisateurSpringSecurity user après model
    public String ajouterUnArticle(@Valid ArticleDTO articleDTO, RetraitDTO retraitDTO, BindingResult bindingResult) {
        articleService.creerArticle(articleDTO);
        retraitService.creerRetrait(retraitDTO);

        if (bindingResult.hasErrors()) {
            return "nouvelArticle";
        }
        return "redirect:/articles";
    }

    @GetMapping("/{noArticle}/modifier")
    public String modifierUnArticleGet(@PathVariable("noArticle") Long noArticle, Model model) {
        model.addAttribute("article", articleService.consulterArticleParNo(noArticle));
        model.addAttribute("retrait", retraitService.consulterRetraitParId(noArticle));
        return "nouvelArticle";
    }


    @GetMapping("/{noArticle}/supprimer")
    public String supprimerUnArticle(@PathVariable("noArticle") Long noArticle, Model model) {
        ArticleDTO articleDTO = articleService.consulterArticleParNo(noArticle);
        RetraitDTO retraitDTO = retraitService.consulterRetraitParId(noArticle);

        model.addAttribute("message", "Etes-vous sûr de vouloir supprimer : " + articleDTO.getNom());
        model.addAttribute("action", "/articles" + noArticle + "/supprimer");
        model.addAttribute("back", "/articles");

        //modal de confirmation
        return "confirmation";
    }

    @PostMapping("/{noArticle}/supprimer")
    public String supprimerUnArticle(@PathVariable("noArticle") Long noArticle) {
        retraitService.supprimerRetrait(noArticle);
        articleService.supprimerArticle(noArticle);
        return "redirect:/articles";
    }

}