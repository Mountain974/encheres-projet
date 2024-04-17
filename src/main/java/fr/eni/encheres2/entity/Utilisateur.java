package fr.eni.encheres2.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serial;
import java.util.Collection;
import java.util.List;

@Entity
@Data
@Table(name = "UTILISATEURS")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Utilisateur implements UserDetails {

    @Serial
    private static final long serialVersionUID = 1L;

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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (isAdministrateur()) {
            return List.of(new SimpleGrantedAuthority("ADMIN"));
        }
        return List.of(new SimpleGrantedAuthority("USER"));
    }

    @Override
    public String getPassword() {
        return motDePasse;
    }

    @Override
    public String getUsername() {
        return pseudo;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}