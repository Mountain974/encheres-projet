package fr.eni.encheres2.dto;

import fr.eni.encheres2.entity.Article;
import fr.eni.encheres2.entity.Utilisateur;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class EnchereDTO {

    @Id
    private Long id;

    @NotNull(message = "la date de l'enchère obligatoire")
    private LocalDate dateEnchere;

    @NotNull(message = "le montant de l'enchère doit être supérieur à zéro")
    private Integer montantEnchere;

    @NotNull(message = "l'acheteur est obligatoire")
    Utilisateur utilisateur;

    @NotNull(message = "Une enchère doit être reliée à un article en vente")
    Article article;

}