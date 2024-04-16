package fr.eni.encheres2.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "no_article")
    private Long noArticle;
    @Column(name = "nom_article", length = 30, nullable = false)
    @NotNull(message = "le nom de l'article est obligatoire")
    @Size(max=30)
    private String nom;
    @NotNull(message = "la description est obligatoire")
    @Column(length = 300, nullable = false)
    @Size(min=10, max=300)
    private String description;
    @Column(name = "date_debut_encheres", nullable = false)
    @NotNull(message = "la date de début des enchères est obligatoire")
    private LocalDate dateDebutEncheres;
    @Column(name = "date_fin_encheres", nullable = false)
    @NotNull(message = "la date de fin des enchères est obligatoire")
    private LocalDate dateFinEncheres;
    @Column(name = "prix_initial")
    private Integer miseAPrix;
    @Column(name = "prix_vente")
    private Integer prixVente;
    @ManyToOne
    @JoinColumn(name = "no_vendeur", nullable = false)
    @NotNull
    Utilisateur vendeur;
    @ManyToOne
    @JoinColumn(name = "no_acheteur")
    Utilisateur acheteur;
    @ManyToOne
    @JoinColumn(name = "no_categorie", nullable = false)
    @NotNull(message = "le choix d'une catégorie est obligatoire")
    Categorie categorie;

    public Article(Long noArticle, String nom, String description, LocalDate dateDebutEncheres, LocalDate dateFinEncheres, Integer miseAPrix, Utilisateur vendeur, Long noCategorie) {
        this.noArticle = noArticle;
        this.nom = nom;
        this.description = description;
        this.dateDebutEncheres = dateDebutEncheres;
        this.dateFinEncheres = dateFinEncheres;
        this.miseAPrix = miseAPrix;
        this.vendeur = vendeur;
        this.categorie = categorie;
    }

    public Article(Long noArticle, String nom, String description, LocalDate dateDebutEncheres, LocalDate dateFinEncheres, Integer miseAPrix, Integer prixVente, Utilisateur vendeur, Categorie categorie, Utilisateur acheteur) {
        this.noArticle = noArticle;
        this.nom = nom;
        this.description = description;
        this.dateDebutEncheres = dateDebutEncheres;
        this.dateFinEncheres = dateFinEncheres;
        this.miseAPrix = miseAPrix;
        this.prixVente = prixVente;
        this.vendeur = vendeur;
        this.categorie = categorie;
        this.acheteur = acheteur;
    }

}
