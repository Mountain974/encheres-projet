package fr.eni.encheres2.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "ENCHERES")
@NoArgsConstructor
public class Enchere {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "la date de l'enchère obligatoire")
    @Column(name="date_enchere")
    private LocalDate dateEnchere;

    @ManyToOne
    @JoinColumn(name = "no_utilisateur")
    Utilisateur utilisateur;

    @ManyToOne
    @JoinColumn(name = "no_article")
    ArticleVendu articleVendu;

}
