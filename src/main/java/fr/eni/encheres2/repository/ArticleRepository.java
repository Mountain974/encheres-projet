package fr.eni.encheres2.repository;

import fr.eni.encheres2.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {

}
