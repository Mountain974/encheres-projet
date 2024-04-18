package fr.eni.encheres2.service;

import fr.eni.encheres2.dto.UtilisateurDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UtilisateurService {

    void creerUtilisateur(UtilisateurDTO utilisateurDTO);

    UtilisateurDTO trouverUtilisateurParId(long id);

    UtilisateurDTO trouverUtilisateurParPseudo (String pseudo);

    UtilisateurDTO trouverUtilisateurParEmail(String email);

    void modifierUtilisateur(UtilisateurDTO utilisateurDTO);

    void supprimerUtilisateur(long id);

    List<UtilisateurDTO> tousLesUtilisateurs();


}
