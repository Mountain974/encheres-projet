package fr.eni.encheres2.controller;

import fr.eni.encheres2.dto.ArticleDTO;
import fr.eni.encheres2.service.ArticleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/articles")
public class ArticleController {

    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping
    public List<ArticleDTO> afficherArticles() {
        return articleService.consulterArticles();
    }

    @GetMapping("/{noArticle}")
    public ResponseEntity<ArticleDTO> afficherUnUtilisateur(@PathVariable Long noArticle) {
        ArticleDTO articleDTO = articleService.consulterArticleVenduParNo(noArticle);
        if (articleDTO != null) {
            return ResponseEntity.ok(articleDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Void> ajouterUnArticle(@RequestBody ArticleDTO articleDTO) {
        articleService.creerArticleVendu(articleDTO);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{noArticle}")
    public ResponseEntity<Void> modifierUnArticle(@PathVariable Long noArticle, @RequestBody ArticleDTO articleDTO) {
        articleDTO.setNoArticle(noArticle);
        articleService.modifierArticleVendu(articleDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{noArticle}")
    public ResponseEntity<Void> supprimerUnArticle(@PathVariable Long noArticle) {
        articleService.supprimerArticleVendu(noArticle);
        return ResponseEntity.ok().build();
    }
}
