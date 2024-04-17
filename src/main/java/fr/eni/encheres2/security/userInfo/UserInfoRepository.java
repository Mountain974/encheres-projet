package fr.eni.encheres2.security.userInfo;

import fr.eni.encheres2.entity.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInfoRepository extends JpaRepository<Utilisateur, String> {
}
