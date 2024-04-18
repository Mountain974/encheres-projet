package fr.eni.encheres2.service;

import fr.eni.encheres2.dto.RetraitDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RetraitService {

    List<RetraitDTO> consulterRetraits();

    RetraitDTO consulterRetraitParId(Long noArticle);

    RetraitDTO creerRetrait(RetraitDTO retraitDTO);

    void modifierRetrait(RetraitDTO retraitDTO);

    void supprimerRetrait(Long noArticle);



}
