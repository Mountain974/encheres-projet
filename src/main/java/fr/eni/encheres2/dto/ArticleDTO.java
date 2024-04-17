package fr.eni.encheres2.dto;

import fr.eni.encheres2.entity.Categorie;
import fr.eni.encheres2.entity.Utilisateur;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;



@Data // génère getter/setter/
@NoArgsConstructor
public class ArticleDTO {
    @Id
    private Long noArticle;
    @NotNull(message = "le nom de l'article est obligatoire")
    @Size(max=30)
    private String nom;
    @NotNull(message = "la description est obligatoire")
    @Size(min=10, max=300)
    private String description;
    @NotNull(message = "la date de début des enchères est obligatoire")
    private LocalDate dateDebutEncheres;
    @NotNull(message = "la date de fin des enchères est obligatoire")
    private LocalDate dateFinEncheres;
    private Integer miseAPrix;
    private Integer prixVente;
    @NotNull(message = "l'acheteur est obligatoire")
    Utilisateur vendeur;
    Utilisateur acheteur;
    @NotNull(message = "le choix d'une catégorie est obligatoire")
    Categorie categorie;
    private String etat;


    public ArticleDTO(Long noArticle, String nom, String description, LocalDate dateDebutEncheres, LocalDate dateFinEncheres, Integer miseAPrix, Utilisateur vendeur, Categorie categorie) {
        this.noArticle = noArticle;
        this.nom = nom;
        this.description = description;
        this.dateDebutEncheres = dateDebutEncheres;
        this.dateFinEncheres = dateFinEncheres;
        this.miseAPrix = miseAPrix;
        this.vendeur = vendeur;
        this.categorie = categorie;
        this.etat = calculerEtat(dateDebutEncheres, dateFinEncheres);
    }

    public ArticleDTO(Long noArticle, String nom, String description, LocalDate dateDebutEncheres, LocalDate dateFinEncheres, Integer miseAPrix, Integer prixVente, Utilisateur vendeur, Categorie categorie, Utilisateur acheteur) {
        this.noArticle = noArticle;
        this.nom = nom;
        this.description = description;
        this.dateDebutEncheres = dateDebutEncheres;

        this.dateFinEncheres = dateFinEncheres;
        this.miseAPrix = miseAPrix;
        this.prixVente = prixVente;
        this.vendeur = vendeur;
        this.categorie = categorie;
        this.etat = calculerEtat(dateDebutEncheres, dateFinEncheres);
        this.acheteur = acheteur;
    }

    private String calculerEtat(LocalDate dateDebutEncheres, LocalDate dateFinEncheres) {
        LocalDate today = LocalDate.now();
        if (dateDebutEncheres.isAfter(today)) {
            return "À venir";
        } else if (dateFinEncheres.isBefore(today)) {
            return "Terminé";
        } else {
            return "En cours";
        }
    }
}
