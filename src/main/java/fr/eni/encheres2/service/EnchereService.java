package fr.eni.encheres2.service;

import fr.eni.encheres2.dto.EnchereDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EnchereService {
    List<EnchereDTO> afficherEncheresParUtilisateur(Long noUtilisateur);
}
