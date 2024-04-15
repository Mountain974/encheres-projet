package fr.eni.encheres2.dto;

import fr.eni.encheres2.entity.ArticleVendu;
import fr.eni.encheres2.entity.Enchere;
import fr.eni.encheres2.utils.AppConstants;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UtilisateurDTO {

    @Id
    private long noUtilisateur;
    @NotNull
    @Size(min = 2, max = 50)
    private String pseudo;
    @NotNull
    @Size(min = 2, max = 80)
    private String nom;
    @NotNull
    @Size(min = 2, max = 80)
    private String prenom;
    @NotNull
    @Email
    @Size(min = 10, max = 80)
    private String email;
    @NotNull
    @Size(min = 10, max = 10)
    private String telephone;
    @NotNull
    private String rue;
    @NotNull
    @Size(min = 5, max = 5)
    private String codePostal;
    @NotNull
    @Size(min = 1, max = 41)
    private String ville;
    @NotNull
    @Size(min = 8, max = 80)
    private String motDePasse;
    @NotNull
    @Min(0)
    private long credit;
    @NotNull
    private boolean administrateur;
    private List<Enchere> encheres;
    private List<ArticleVendu> articlesVendus;

    public UtilisateurDTO(String pseudo, String nom, String prenom, String email, String telephone, String rue, String codePostal, String ville, String motDePasse) {
        this.pseudo = pseudo;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.telephone = telephone;
        this.rue = rue;
        this.codePostal = codePostal;
        this.ville = ville;
        this.motDePasse = motDePasse;
        setCredit(AppConstants.INITIAL_CREDIT);
        setAdministrateur(false);
    }

}
