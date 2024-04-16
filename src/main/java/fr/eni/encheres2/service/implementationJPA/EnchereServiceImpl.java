package fr.eni.encheres2.service.implementationJPA;

import fr.eni.encheres2.dto.EnchereDTO;
import fr.eni.encheres2.service.EnchereService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnchereServiceImpl implements EnchereService {

    //    Méthode à compléter lorsque la classe Enchere sera développée
    @Override
    public List<EnchereDTO> afficherEncheresParUtilisateur(Long noUtilisateur) {
        return List.of();
    }
}
