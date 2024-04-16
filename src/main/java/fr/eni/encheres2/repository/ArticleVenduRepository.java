package fr.eni.encheres2.repository;


import fr.eni.encheres2.entity.ArticleVendu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ArticleVenduRepository extends JpaRepository<ArticleVendu, Long> {
    @Query("select article from ArticleVendu article where article.nom like %:search%")
    List<ArticleVendu> searchByNom(String search);

    @Query("SELECT article FROM ArticleVendu article " +
            "WHERE CASE " +
            "  WHEN article.dateDebutEncheres > CURRENT_DATE THEN 'A venir' " +
            "  WHEN article.dateFinEncheres < CURRENT_DATE THEN 'Terminé' " +
            "  ELSE 'En cours' " +
            "END = :etat")
    List<ArticleVendu> findByEtat(@Param("etat") String etat);

    @Query("select article from ArticleVendu article " +
            "INNER JOIN article.categorie cat " +
            "WHERE cat.libelle = :categorie")
    List<ArticleVendu> searchByCategorie(@Param("categorie") String categorie);

}
