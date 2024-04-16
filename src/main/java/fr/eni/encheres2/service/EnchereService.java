package fr.eni.encheres2.service;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EnchereService {

    List<EnchereDTO1> consulterEncheres();

    EnchereDTO1 consulterEnchereParId(Long id);

    EnchereDTO1 creerEnchere(EnchereDTO1 enchere);

    List<EnchereDTO1> afficherEncheresParUtilisateur(Long noUtilisateur);

}
