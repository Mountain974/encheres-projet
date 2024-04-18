package fr.eni.encheres2.repository;

import fr.eni.encheres2.entity.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {

    Utilisateur findByEmail(String email);

    Utilisateur findByPseudo(String pseudo);

    boolean existsByPseudo(String username);

    boolean existsByEmail(String email);
}
