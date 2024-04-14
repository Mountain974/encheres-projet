package fr.eni.encheres2.service;

import fr.eni.encheres2.dto.RetraitDTO;
import org.springframework.stereotype.Service;

@Service
public interface RetraitService {

    RetraitDTO consulterRetraitParId(Long noArticle);

    RetraitDTO creerRetrait(RetraitDTO retraitDTO);

    void modifierRetrait(RetraitDTO retraitDTO);

    void supprimerRetrait(Long noArticle);



}
