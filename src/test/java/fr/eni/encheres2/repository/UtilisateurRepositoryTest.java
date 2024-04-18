package fr.eni.encheres2.repository;

import fr.eni.encheres2.dto.UtilisateurDTO;
import fr.eni.encheres2.entity.Utilisateur;
import fr.eni.encheres2.service.implementationJPA.UtilisateurServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UtilisateurRepositoryTest {

    @Mock
    private UtilisateurRepository utilisateurRepository;

    @InjectMocks
    private UtilisateurServiceImpl utilisateurService;

    @Test
    public void testFindAll() {
        List<Utilisateur> users = new ArrayList<>();
        users.add(Utilisateur.builder().nom("Bombeurre").prenom("Jean").build());
        users.add(Utilisateur.builder().nom("Paltant").prenom("Roger").build());
        when(utilisateurRepository.findAll()).thenReturn(users);

        List<UtilisateurDTO> result = utilisateurService.tousLesUtilisateurs();

        assertEquals(users.size(), result.size());
    }

    @Test
    public void testFindById() {
        Utilisateur user = Utilisateur.builder().noUtilisateur(123).nom("Bombeurre").prenom("Jean").build();
        when(utilisateurRepository.findById(123L)).thenReturn(Optional.ofNullable(user));

        UtilisateurDTO result = utilisateurService.trouverUtilisateurParId(123L);

        assertEquals("Bombeurre", result.getNom());
    }
}
