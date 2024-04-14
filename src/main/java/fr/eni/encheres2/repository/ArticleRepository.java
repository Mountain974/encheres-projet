package fr.eni.encheres2.repository;

import fr.eni.encheres2.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {

    @Query("select article from Article article where article.nom like %:search%")
    List<Article> searchByNom(String search);

    @Query("SELECT article FROM Article article " +
            "WHERE CASE " +
            "  WHEN article.dateDebutEncheres > CURRENT_DATE THEN 'A venir' " +
            "  WHEN article.dateFinEncheres < CURRENT_DATE THEN 'Terminé' " +
            "  ELSE 'En cours' " +
            "END = :etat")
    List<Article> findByEtat(@Param("etat") String etat);

    @Query("select article from Article article " +
            "INNER JOIN article.categorie cat " +
            "WHERE cat.libelle = :categorie")
    List<Article> searchByCategorie(@Param("categorie") String categorie);

}
