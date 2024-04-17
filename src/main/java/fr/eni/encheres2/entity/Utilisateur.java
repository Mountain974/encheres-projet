package fr.eni.encheres2.entity;

import fr.eni.encheres2.utils.AppConstants;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "UTILISATEURS")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "no_utilisateur")
    private long noUtilisateur;
    @NotNull(message = "Le pseudo est obligatoire")
    @Size(min = 2, max = 50)
    @Column(length = 50, nullable = false)
    private String pseudo;
    @NotNull(message = "Le nom est obligatoire")
    @Size(min = 2, max = 80)
    @Column(length = 80, nullable = false)
    private String nom;
    @NotNull(message = "Le prénom est obligatoire")
    @Size(min = 2, max = 80)
    @Column(length = 80, nullable = false)
    private String prenom;
    @NotNull(message = "L'email est obligatoire")
    @Email
    @Size(min = 10, max = 80)
    @Column(length = 80, nullable = false)
    private String email;
    @NotNull(message = "Le numéro de téléphone est obligatoire")
    @Size(min = 10, max = 10)
    @Column(length = 10, nullable = false)
    private String telephone;
    @NotNull(message = "La rue est obligatoire")
    private String rue;

    @NotNull(message = "Le code postal est obligatoire")
    @Size(min = 5, max = 5)
    @Column(name = "code_postal", length = 5, nullable = false)
    private String codePostal;

    @NotNull(message = "La ville est obligatoire")
    @Size(min = 1, max = 41)
    @Column(length = 41, nullable = false)
    private String ville;
    @NotNull(message = "Le mot de passe est obligatoire")
    @Size(min = 8, max = 80)
    @Column(name = "mot_de_passe", length = 80, nullable = false)
    private String motDePasse;
    @NotNull(message = "Le crédit est obligatoire")
    @Min(0)
    private long credit;
    @NotNull(message = "Le statut administrateur est obligatoire")
    private boolean administrateur;
    @Transient
    private transient String roles;

    public Utilisateur(String pseudo, String nom, String prenom, String email, String telephone, String rue, String codePostal, String ville, String motDePasse) {
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
        setRoles("USER");
    }
}